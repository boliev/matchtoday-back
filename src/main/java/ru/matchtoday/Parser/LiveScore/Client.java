package ru.matchtoday.Parser.LiveScore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import ru.matchtoday.Controller.CalendarController;
import ru.matchtoday.Parser.DTO.MatchDto;
import ru.matchtoday.Parser.DTO.TeamDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.dariawan.com/tutorials/java/introduction-to-java-11-standarized-http-client-api/
@Service
public class Client {
    private String scheme = "https";
    private String host = "livescore-api.com/api-client/";
    private String key = "";
    private String secret = "";

    private HttpClient client = HttpClient.newHttpClient();

    private Logger logger = LoggerFactory.getLogger(CalendarController.class);

    public List<MatchDto> getTournamentMatches(String tournamentId) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("competition_id", tournamentId);
        URI uri = getUri("/fixtures/matches.json", params);
        ArrayList<MatchDto> matches = new ArrayList<MatchDto>();

        while (true) {
            JSONObject json = get(uri);
            JSONObject data = json.getJSONObject("data");
            JSONArray matchesJson = data.getJSONArray("fixtures");
            for (int i = 0; i < matchesJson.length(); i++) {
                matches.add(createMatch(matchesJson.getJSONObject(i)));
            }
            try {
                String nextPage = data.getString("next_page");
                uri = URI.create(nextPage);
            } catch (JSONException e) {
                break;
            }
        }

        return matches;
    }

    public JSONObject get(URI uri) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response;
        String body = "[]";
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            body = response.body();
        } catch (IOException | InterruptedException e) {
            logger.error(e.getMessage());
        }

        return new JSONObject(body);
    }

    private URI getUri(String method, HashMap<String, String> parameters) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme(scheme)
                .host(host)
                .path(method)
                .queryParam("key", key)
                .queryParam("secret", secret);
        for (Map.Entry<String, String> param : parameters.entrySet()) {
            builder.queryParam(param.getKey(), param.getValue());
        }
        return builder.build().toUri();
    }

    private MatchDto createMatch(JSONObject matchJson) {
        TeamDto homeTeam = new TeamDto(
                matchJson.getString("home_id"),
                matchJson.getString("home_name")
        );
        TeamDto awayTeam = new TeamDto(
                matchJson.getString("away_id"),
                matchJson.getString("away_name")
        );

        return new MatchDto(
                matchJson.getString("id"),
                matchJson.getString("date"),
                matchJson.getString("time"),
                matchJson.getString("round"),
                homeTeam,
                awayTeam,
                matchJson.getString("competition_id")
        );
    }
}
