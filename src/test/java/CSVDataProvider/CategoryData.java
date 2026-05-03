package CSVDataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class CategoryData {
    @DataProvider(name = "categoryData")
    public Object[][] categoryData() {
        String csvFile = "src/test/resources/test_data/category-data.csv";
        List<Object[]> testData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Bỏ qua dòng tiêu đề
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String categoryName = data[1];
                String description = data[2];
                String expectedMsg = data[3];
                testData.add(new Object[] { id, categoryName, description, expectedMsg });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData.toArray(new Object[0][]);
    }
}