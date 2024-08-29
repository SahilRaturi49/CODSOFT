package sahil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base currency:");
        String convertFrom = scanner.nextLine();
        System.out.print("Enter the target currency:");
        String convertTo = scanner.nextLine();
        System.out.print("Amount:");
        BigDecimal quantity = scanner.nextBigDecimal();

        String urlString = "https://www.frankfurter.app/latest?from=" + convertFrom.toUpperCase();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlString)
                .get()
                .build();

        Response resp = client.newCall(request).execute();
        String stringResponse = resp.body().string();
        JSONObject jsonObject = new JSONObject(stringResponse);
        JSONObject ratesObject = jsonObject.getJSONObject("rates");
        BigDecimal rate = ratesObject.getBigDecimal(convertTo.toUpperCase());

        BigDecimal result = rate.multiply(quantity);

        Currency currency = Currency.getInstance(convertTo.toUpperCase());
        String symbol = currency.getSymbol();
        System.out.println(symbol+result);

    }
}
