package com.herokuapp.theinternet.utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.*;

public class DataProviderCSV
{
    @DataProvider(name = "csvReader")
    public static Iterator<Object[]> csvReader(Method method)
    {
        List<Object[]> list = new ArrayList<>();
        List<String> pathElements = new ArrayList<>(List.of("src", "test", "resources", "dataprovider", method.getDeclaringClass().getSimpleName(), method.getName()));

        File file = new File(String.join(File.separator, pathElements) + ".csv");

        try
        {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] keys = reader.readNext();

            if (keys != null)
            {
                String[] dataParts;

                while ((dataParts = reader.readNext()) != null)
                {
                    Map<String, String> testData = new HashMap<>();

                    for (int i = 0; i < keys.length; i++)
                    {
                        testData.put(keys[i], dataParts[i]);
                    }

                    list.add(new Object[] {testData});
                }
            }

            reader.close();
        }
        catch (FileNotFoundException fnf)
        {
            throw new RuntimeException("File " + file.toString() + " was not found.\n" + Arrays.toString(fnf.getStackTrace()));
        }
        catch (IOException | CsvValidationException ioe)
        {
            throw new RuntimeException("Could not read " + file.toString() + " file.\n" + Arrays.toString(ioe.getStackTrace()));
        }

        return list.iterator();
    }

}
