package com.wipro.intern.helper;

import com.wipro.intern.domain.Persons;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {


    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }
    public static boolean  onlyDigits(String str)
    {
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        if (str == null) {
            return false;
        }
        Matcher m = p.matcher(str);
        return m.matches();
    }

    //convert excel to list of products

    public static List<Persons> convertExcelToListOfProduct(InputStream is) {
        List<Persons> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("person");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                Persons p = new Persons();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
//                        case 0:
//                            p.setId((int) cell.getNumericCellValue());
//                            break;
                        case 1:
                            p.setFirstName(cell.getStringCellValue());
                            break;
                        case 2:
                            p.setLastName(cell.getStringCellValue());
                            break;
                        case 3:
                            p.setMiddleName(cell.getStringCellValue());
                            break;
                        case 4:
                            p.setEmail(cell.getStringCellValue());
                            break;
                        case 5:
                            p.setStreet(cell.getStringCellValue());
                            break;
                        case 6:
                            p.setCity(cell.getStringCellValue());
                            break;
                        case 7:
                            p.setState(cell.getStringCellValue());
                            break;
                        case 8:
                            p.setCountry(cell.getStringCellValue());
                            break;
                        case 9:
                            p.setPincode(cell.getStringCellValue());
                            break;
                        case 10:
                            p.setEmployerName(cell.getStringCellValue());
                            break;
                        case 11:
                            p.setEmployerId(cell.getStringCellValue());
                            break;
                        case 12:
                            p.setEmployerStreet(cell.getStringCellValue());
                            break;
                        case 13:
                            p.setEmployerCity(cell.getStringCellValue());
                            break;
                        case 14:
                            p.setEmployerState(cell.getStringCellValue());
                            break;
                        case 15:
                            p.setEmployerCountry(cell.getStringCellValue());
                            break;
                        case 16:
                            p.setEmployerPincode(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(p);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


}
