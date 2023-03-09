package practice;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
    private boolean inTitle = false; // title 요소 안에 있는지 여부를 저장하는 변수
    private boolean inAuthor = false; // author 요소 안에 있는지 여부를 저장하는 변수
    private boolean inPublisher = false; // publisher 요소 안에 있는지 여부를 저장하는 변수
    private boolean inPrice = false; // price 요소 안에 있는지 여부를 저장하는 변수

    // 요소의 시작 태그를 만났을 때 호출되는 메소드
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "title":
                inTitle = true; // title 요소 안에 있다고 표시
                break;
            case "author":
                inAuthor = true; // author 요소 안에 있다고 표시
                break;
            case "publisher":
                inPublisher = true; // publisher 요소 안에 있다고 표시
                break;
            case "price":
                inPrice = true; // price 요소 안에 있다고 표시
                break;
        }
    }
    
    // 요소의 텍스트 내용을 만났을 때 호출되는 메소드
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inTitle) { // title 요소 안에 있다면
            String title = new String(ch, start, length); // 텍스트 내용을 문자열로 변환하여 저장
            System.out.println("Title: " + title); // 출력
            inTitle = false; // title 요소 안에 있지 않다고 표시
        }
        if (inAuthor) { // author 요소 안에 있다면
            String author = new String(ch, start, length); // 텍스트 내용을 문자열로 변환하여 저장
            System.out.println("Author: " + author); // 출력
            inAuthor = false; // author 요소 안에 있지 않다고 표시
        }
        if (inPublisher) { // publisher 요소 안에 있다면
            String publisher = new String(ch, start, length); // 텍스트 내용을 문자열로 변환하여 저장
            System.out.println("Publisher: " + publisher); // 출력
            inPublisher = false; // publisher 요소 안에 있지 않다고 표시
        }
        if (inPrice) { // price 요소 안에 있다면
            String price = new String(ch, start, length); // 텍스트 내용을 문자열로 변환하여 저장
            System.out.println("Price: " + price); // 출력
            inPrice = false; // price 요소 안에 있지 않다고 표시
        }
    }
}
