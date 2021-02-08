package by.tms.service;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryStorage {
    private static List<Double> results = new ArrayList<>();

    public void save(double result){
        results.add(result);
    }

    public List<Double> getResults(){
        return new ArrayList<>(results);
    }

}

// user 3 парамами (консутруктор один со всеми парамами, другой без айди парама)
// user по аналогии с operation создаем


// postMapping (httpSession) ${session.)
