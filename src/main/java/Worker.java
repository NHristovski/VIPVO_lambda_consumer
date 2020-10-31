import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Worker implements Runnable {
    @Override
    public void run() {
        RestTemplate restTemplate = new RestTemplate();
        List<Long> responseTimes = new ArrayList<>();

        System.out.println("Worker " + Thread.currentThread().getId() + " started");

        AdditionResponse additionResponseTest = restTemplate.postForObject("https://kbt4igy0a5.execute-api.eu-central-1.amazonaws.com/default/MyFirstLamba",
                AdditionRequest.builder()
                        .id(1L)
                        .firstNumber(10L)
                        .secondNumber(20L)
                        .build(),
                AdditionResponse.class);

        for (int i =0; i < 1_000; i++) {

            long before = System.currentTimeMillis();

            AdditionResponse additionResponse = restTemplate.postForObject("https://kbt4igy0a5.execute-api.eu-central-1.amazonaws.com/default/MyFirstLamba",
                    AdditionRequest.builder()
                            .id(1L)
                            .firstNumber(10L)
                            .secondNumber(20L)
                            .build(),
                    AdditionResponse.class);

            long after = System.currentTimeMillis();

            long responseTime = after - before;

            responseTimes.add(responseTime);
        }

        System.out.println("Worker " + Thread.currentThread().getId() + " Average: " + responseTimes
                .stream()
                .mapToInt(Long::intValue)
                .average()
                .getAsDouble() + "ms");
    }
}
