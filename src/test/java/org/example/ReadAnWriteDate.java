package org.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadAnWriteDate {

    public static void main(String[] args) {
        // Read data from Excel sheet and store in a List
        List<StudentData> studentDataList = readDataFromExcel(System.getProperty("user.dir")+"/testdata/data.xlsx");

        // Display the data in the console
        displayData(studentDataList);
    }

    private static List<StudentData> readDataFromExcel(String filePath) {
        List<StudentData> studentDataList = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath))) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            Iterator<Row> iterator = sheet.iterator();
            // Skipping the header row
            if (iterator.hasNext()) {
                iterator.next();
            }

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                String name = cellIterator.next().getStringCellValue();
                String courses = cellIterator.next().getStringCellValue();
                double fee = cellIterator.next().getNumericCellValue();

                // Create StudentData object and add to the list
                StudentData student = new StudentData(name, courses, fee);
                studentDataList.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentDataList;
    }

    private static void displayData(List<StudentData> studentDataList) {
        System.out.printf("%-15s %-15s %-10s%n", "Name", "Courses", "Fee");
        System.out.println("---------------------------------------");

        for (StudentData student : studentDataList) {
            System.out.printf("%-15s %-15s $%.2f%n", student.getName(), student.getCourses(), student.getFee());
        }
    }

    private static class StudentData {
        private String name;
        private String courses;
        private double fee;

        public StudentData(String name, String courses, double fee) {
            this.name = name;
            this.courses = courses;
            this.fee = fee;
        }

        public String getName() {
            return name;
        }

        public String getCourses() {
            return courses;
        }

        public double getFee() {
            return fee;
        }
    }
}
