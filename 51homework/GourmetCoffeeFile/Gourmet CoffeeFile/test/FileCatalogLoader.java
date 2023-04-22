import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader {
    private Product readProduct(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        String code = "";
        String description = "";
        double price = 0.0;
        String type = "";
        try {
            type = tokenizer.nextToken().trim();
            code = tokenizer.nextToken().trim();
            description = tokenizer.nextToken().trim();
            price = Double.parseDouble(tokenizer.nextToken().trim());
        } catch (NoSuchElementException | NumberFormatException e) {
            throw new DataFormatException(line);
        }
        return new Product(code, description, price);
    }

    private Coffee readCoffee(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        String type = "";
        String code = "";
        String description = "";
        double price = 0.0;
        String origin = "";
        String roast = "";
        String flavor = "";
        String aroma = "";
        String acidity = "";
        String body = "";
        try {
            type = tokenizer.nextToken().trim();
            code = tokenizer.nextToken().trim();
            description = tokenizer.nextToken().trim();
            price = Double.parseDouble(tokenizer.nextToken().trim());
            origin = tokenizer.nextToken().trim();
            roast = tokenizer.nextToken().trim();
            flavor = tokenizer.nextToken().trim();
            aroma = tokenizer.nextToken().trim();
            acidity = tokenizer.nextToken().trim();
            body = tokenizer.nextToken().trim();

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new DataFormatException(line);
        }
        return new Coffee(code, description, price, origin, roast, flavor, aroma, acidity, body);
    }

    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        String type = "";
        String code = "";
        String description = "";
        double price = 0.0;
        String model = "";
        String waterSupply = "";
        int numberOfCups = 0;
        try {
            type = tokenizer.nextToken().trim();
            code = tokenizer.nextToken().trim();
            description = tokenizer.nextToken().trim();
            price = Double.parseDouble(tokenizer.nextToken().trim());
            model = tokenizer.nextToken().trim();
            waterSupply = tokenizer.nextToken().trim();
            numberOfCups = Integer.parseInt(tokenizer.nextToken().trim());
        } catch (NoSuchElementException | NumberFormatException e) {
            throw new DataFormatException(line);
        }
        return new CoffeeBrewer(code, description, price, model, waterSupply, numberOfCups);
    }

    public Catalog loadCatalog(String filename) throws FileNotFoundException, IOException, DataFormatException {
        Catalog catalog = new Catalog();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Product")) {
                    catalog.addProduct(readProduct(line));
                } else if (line.startsWith("Coffee")) {
                    catalog.addProduct(readCoffee(line));
                } else if (line.startsWith("Brewer")) {
                    catalog.addProduct(readCoffeeBrewer(line));
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("The specified file does not exist.");
        } catch (IOException e) {
            throw new IOException("There is an error reading the information in the specified file.");
        } catch (DataFormatException e) {
            throw new DataFormatException("A line in the file has errors: " + e.getMessage());
        }
        return catalog;
    }
}
