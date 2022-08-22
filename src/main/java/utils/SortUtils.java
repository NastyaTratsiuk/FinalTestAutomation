package utils;

import models.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortUtils {

    public static List<Test> sortTestByDate(List<Test> testList) {
        return testList.stream()
                .sorted(Comparator.comparing(Test::getStartTime).reversed())
                .collect(Collectors.toList());
    }
}