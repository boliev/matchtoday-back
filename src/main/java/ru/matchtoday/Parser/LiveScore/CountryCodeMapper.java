package ru.matchtoday.Parser.LiveScore;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.stereotype.Service;
import ru.matchtoday.Parser.Exception.WrongCountryException;

import java.util.List;

// https://github.com/TakahikoKawasaki/nv-i18n/blob/master/src/main/java/com/neovisionaries/i18n/CountryCode.java
@Service
public class CountryCodeMapper {

    public String getCode(String countryName) {
        if (countryName.equals("Russia")) {
            countryName = "Russian Federation";
        }

        List<CountryCode> code = CountryCode.findByName(countryName);

        if (code.size() != 1) {
            throw new WrongCountryException("Cannot find country code for " + countryName);
        }

        return code.get(0).getAlpha3();
    }
}
