import java.util.*;

public class DuplicatesList {

    public static void printDuplicateAndUniqueElements(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> duplicatesList = new ArrayList<>();
        List<Integer> uniqueList = new ArrayList<>();

        for (int num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > 1) {
                duplicatesList.add(num);
            } else {
                uniqueList.add(num);
            }
        }

        System.out.println("Duplicate elements: " + duplicatesList);
        System.out.println("Non-Duplicate elements: " + uniqueList);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            list.add(element);
        }
        scanner.close();

        printDuplicateAndUniqueElements(list);
    }
}
