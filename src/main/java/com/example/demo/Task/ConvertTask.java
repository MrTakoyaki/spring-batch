package com.example.demo.Task;

import com.example.demo.Vo.XmlVo;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertTask implements Tasklet {
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        Convert("D:\\桌面\\xml-excel\\其他.xml");
        System.out.println("Task done...");
        return RepeatStatus.FINISHED;
    }


    public void Convert(String path) {
        try {
            XmlVo xmlVo = new XmlVo();
            XSSFWorkbook workbook = new XSSFWorkbook();

            File file = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("Info");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element iElement = (Element) nNode;
                    xmlVo.setVersion(iElement.getAttribute("version"));
                    xmlVo.setUID(iElement.getAttribute("UID"));
                    xmlVo.setTitle(iElement.getAttribute("title"));
                    xmlVo.setCategory(iElement.getAttribute("category"));
                    xmlVo.setShowUnit(iElement.getAttribute("showUnit"));
                    xmlVo.setDescriptionFilterHtml(iElement.getAttribute("descriptionFilterHtml"));

                    NodeList showInfo = iElement.getElementsByTagName("showInfo");
                    for (int i = 0; i < showInfo.getLength(); i++) {
                        Node snode = showInfo.item(0);
                        if (snode.getNodeType() == Node.ELEMENT_NODE) {
                            Element sElement = (Element) snode;

                            NodeList eList = sElement.getElementsByTagName("element");
                            for (int j = 0; j < eList.getLength(); j++) {
                                Node enode = eList.item(j);

                                if (enode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element eElement = (Element) enode;
                                    xmlVo.setTime(eElement.getAttribute("time"));
                                    xmlVo.setLocation(eElement.getAttribute("location"));
                                    xmlVo.setLocationName(eElement.getAttribute("locationName"));
                                    xmlVo.setOnsales(eElement.getAttribute("onsales"));
                                    xmlVo.setLatitude(eElement.getAttribute("latitude"));
                                    xmlVo.setLongitude(eElement.getAttribute("longitude"));
                                    xmlVo.setPrice(eElement.getAttribute("price"));

                                }
                            }
                        }
                    }
                }
//                System.out.println(xmlVo);

                XSSFSheet sheet = workbook.createSheet();
                XSSFRow row = sheet.createRow(0);
                row.createCell(0).setCellValue("version");
                row.createCell(1).setCellValue(xmlVo.getVersion());

                row = sheet.createRow((short) 1);
                row.createCell(0).setCellValue("UID");
                row.createCell(1).setCellValue(xmlVo.getUID());

                row = sheet.createRow((short) 2);
                row.createCell(0).setCellValue("title");
                row.createCell(1).setCellValue(xmlVo.getTitle());

                row = sheet.createRow((short) 3);
                row.createCell(0).setCellValue("category");
                row.createCell(1).setCellValue(xmlVo.getCategory());

                row = sheet.createRow((short) 4);
                row.createCell(0).setCellValue("showUnit");
                row.createCell(1).setCellValue(xmlVo.getShowUnit());

                row = sheet.createRow((short) 5);
                row.createCell(0).setCellValue("descriptionFilterHtml");
                row.createCell(1).setCellValue(xmlVo.getDescriptionFilterHtml());

                row = sheet.createRow((short) 6);
                row.createCell(0).setCellValue("time");
                row.createCell(1).setCellValue(xmlVo.getTime());

                row = sheet.createRow((short) 7);
                row.createCell(0).setCellValue("location");
                row.createCell(1).setCellValue(xmlVo.getLocation());

                row = sheet.createRow((short) 8);
                row.createCell(0).setCellValue("locationName");
                row.createCell(1).setCellValue(xmlVo.getLocation());

                row = sheet.createRow((short) 9);
                row.createCell(0).setCellValue("onsales");
                row.createCell(1).setCellValue(xmlVo.getOnsales());

                row = sheet.createRow((short) 10);
                row.createCell(0).setCellValue("latitude");
                row.createCell(1).setCellValue(xmlVo.getLatitude());

                row = sheet.createRow((short) 11);
                row.createCell(0).setCellValue("longitude");
                row.createCell(1).setCellValue(xmlVo.getLongitude());

                row = sheet.createRow((short) 12);
                row.createCell(0).setCellValue("price");
                row.createCell(1).setCellValue(xmlVo.getPrice());

            }

            String fileName = file.getName();
            String filePath = path.substring(0, path.lastIndexOf("\\"));
            String noExtension = fileName.substring(0, fileName.lastIndexOf("."));

            FileOutputStream out = new FileOutputStream(new File(filePath + "\\" + noExtension + ".xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (IOException | SAXException | ParserConfigurationException e) {
            System.out.println(e);
        }
    }
}