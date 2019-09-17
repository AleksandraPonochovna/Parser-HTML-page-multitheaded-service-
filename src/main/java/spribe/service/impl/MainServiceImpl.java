package spribe.service.impl;

import spribe.service.MainService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainServiceImpl implements MainService {

    public synchronized List<String> getTokens(String text) {
        List<String> token = new ArrayList<>();
        Pattern pattern = Pattern.compile("[а-яa-z]+-?[а-яa-z]+",
                Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            token.add(matcher.group());
        }
        return token;
    }

    public synchronized int getCountTokens(List<String> text, String input) {
        int count = 0;
        for (String token : text) {
            if (token.equalsIgnoreCase(input)) {
                count++;
            }
        }
        return count;
    }

}
