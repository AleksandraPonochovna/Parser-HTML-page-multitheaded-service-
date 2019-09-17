package spribe;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import spribe.parser.Parser;
import spribe.service.impl.ArticleServiceImpl;
import spribe.service.impl.MainServiceImpl;

public class MainApp {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(Objects.requireNonNull(Parser.parse(i)));
        }
        executor.shutdown();
    }

    public synchronized void match(String s) {
        MainServiceImpl mainServiceImpl = new MainServiceImpl();
        ArticleServiceImpl repositoryServiceImpl = new ArticleServiceImpl();
        List<String> token = mainServiceImpl
                .getTokens(repositoryServiceImpl.getArticleList().get(4).getContent());
        System.out.println(mainServiceImpl.getCountTokens(token, s));
    }

}
