package utils;

import enums.BrowserType;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CsvAndEnumProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws IOException {
        String csvFilePath = "src/test/resources/validCredentials.csv";
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));

        List<Arguments> argumentsList = new ArrayList<>();

        reader.lines().forEach(line -> {
            String[] data = line.split(",");
            if (data.length >= 2) {
                String username = data[0].trim();
                String password = data[1].trim();

                for (BrowserType browserType : BrowserType.values()) {
                    argumentsList.add(Arguments.of(username, password, browserType));
                }
            }
        });

        reader.close();

        return argumentsList.stream();
    }
}

