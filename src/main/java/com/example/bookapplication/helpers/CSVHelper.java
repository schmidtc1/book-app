package com.example.bookapplication.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookapplication.models.Book;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Id", "Title", "Description", "Published" };

    public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
        return false;
    }

    return true;
    }

    public static List<Book> csvToBooks(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withQuoteMode(QuoteMode.NON_NUMERIC));) {

        List<Book> books = new ArrayList<Book>();

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();
        int i = 0;
        for (CSVRecord csvRecord : csvRecords) {
            if (i > 20000) return books;
            // Long id, String isbn, String title, String author, Integer published, String publisher
            if (!csvRecord.get("ISBN").isEmpty()) {
                Book book = new Book(
                    csvRecord.get("ISBN"), 
                    csvRecord.get("Book-Title"), 
                    csvRecord.get("Book-Author"), 
                    Integer.parseInt(csvRecord.get("Year-Of-Publication")), 
                    csvRecord.get("Publisher")
                );
                books.add(book);
                i++;
            }
        }

        return books;
    } catch (IOException e) {
        throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
    }
}
