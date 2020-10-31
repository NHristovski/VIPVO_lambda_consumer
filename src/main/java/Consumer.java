import java.util.ArrayList;
import java.util.List;

public class Consumer {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Worker()));
        }

        for (int i = 0; i < 10; i++) {
            threads.get(i).start();
        }

        for (int i = 0; i < 10; i++) {
            threads.get(i).join();
        }


//        RestTemplate restTemplate = new RestTemplate();
//        List<Long> responseTimes = new ArrayList<>();
//
//        AdditionResponse additionResponseTest = restTemplate.postForObject("https://kbt4igy0a5.execute-api.eu-central-1.amazonaws.com/default/MyFirstLamba",
//                AdditionRequest.builder()
//                        .id(1L)
//                        .firstNumber(10L)
//                        .secondNumber(20L)
//                        .build(),
//                AdditionResponse.class);
//
//        for (int i = 0; i < 1_000; i++) {
//
//            long before = System.currentTimeMillis();
//
//            AdditionResponse additionResponse = restTemplate.postForObject("https://kbt4igy0a5.execute-api.eu-central-1.amazonaws.com/default/MyFirstLamba",
//                    AdditionRequest.builder()
//                            .id(1L)
//                            .firstNumber(10L)
//                            .secondNumber(20L)
//                            .build(),
//                    AdditionResponse.class);
//            long after = System.currentTimeMillis();
//            long responseTime = after - before;
//            responseTimes.add(responseTime);
//            System.out.println("Response time: " + responseTime + " ms");
//        }
//
//        System.out.println("Average: " + responseTimes.stream()
//                .mapToInt(Long::intValue).average().getAsDouble());
    }
}
