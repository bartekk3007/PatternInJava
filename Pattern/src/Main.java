import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        String input = "123123.java 123456.java 789789.java";
        Pattern pattern = Pattern.compile("[0-9]*\\.java");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
        {
            System.out.println(matcher.group());
        }

        Stream<String> strings = Stream.of("Portugalia", "Polska", "Pakistan", "Paragwaj", "Panama");
        Pattern patternCountry = Pattern.compile("Po[a-z]*");
        Stream<String> result = strings.filter(patternCountry.asPredicate());
        result.forEach(System.out::println);

        Stream<String> countries = Stream.of("Anglia", "Ameryka", "Argentyna", "Australia", "Austria");
        String combinedString = countries.collect(Collectors.joining(" "));
        Pattern patternAu = Pattern.compile("au\\pL*", Pattern.CASE_INSENSITIVE);
        var matches = patternAu.matcher(combinedString).results().map(MatchResult::group).toList();
        matches.forEach(System.out::println);


        var in = new Scanner(Paths.get("wyniki.txt"));
        Pattern wordPattern = Pattern.compile("\\d.*");
        Stream<String> words = in.findAll(wordPattern).map(MatchResult::group);
        words.forEach(System.out::println);
    }
}