import java.util.Map;
import java.util.TreeMap;

public class StringCompression {

	public static void main(String[] args) {
		String input = "Planeje para o futuro: Pense em objetivos de longo prazo, como aposentadoria, compra de uma casa ou educação dos filhos, e comece a poupar para eles desde já.";
		System.out.println(compressString(input, true));
		System.out.println(compressString(input, false));
	}

	private static String compressString(String input, boolean caseValue) {
        Map<Character, Integer> charCountMap = new TreeMap<>();
        char[] inputArray = caseValue ? input.toLowerCase().toCharArray() : input.toCharArray();
        int count = 0;
        for (int i = 0; i < inputArray.length; i++) {
            count++;
            if (i + 1 >= inputArray.length || inputArray[i + 1] != inputArray[i]) {
                charCountMap.put(inputArray[i], charCountMap.getOrDefault(inputArray[i], 0) + count);
                count = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        return sb.toString().length() > input.length() ? input : sb.toString().replace(" ", "space");
    }
}
