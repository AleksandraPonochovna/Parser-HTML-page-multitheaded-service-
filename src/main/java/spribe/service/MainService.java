package spribe.service;

import java.util.List;

public interface MainService {

    List<String> getTokens(String text);

    int getCountTokens(List<String> text, String input);

}
