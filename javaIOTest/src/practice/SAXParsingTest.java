package practice;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SAXParsingTest {
    public static void main(String[] args) {
       //SAX 파서를 생성하는 코드
    	File file = new File("D:\\A_TeachingMetereal\\3_highjava\\workspace\\javaIOTest\\src\\practice\\XMLtest.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            //이벤트 핸들러를 생성하고 SAX파서에 등록하는 코드
            PeopleSaxHandler handler = new PeopleSaxHandler();
            parser.parse(file, handler);
            
            // 파싱된 결과를 출력하는 코드
            List<Person> list = handler.getPersonList();
            for(Person p:list) {
                System.out.println(p);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
//XML 파일에서 추출된 사람 정보를 저장하기 위한 Person 클래스
class Person {
    /*
        간단하게 xml 파일에서 데이터를 저장하기 위한
        나이, 이름, 성별, 직업 을 가지는 Person 이라는 객체를 만든다.
     */
    private int age;
    private String name;
    private String gender;
    private String role;
    public Person() {
    };
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "이름:"+name+" 나이:"+age+" 성별:"+gender+" 직책:"+role+"\n";
    }
}

//XML 파일에서 데이터를 추출하고 Person 객체에 저장하는 이벤트 핸들러 클래스
class PeopleSaxHandler extends DefaultHandler {

    //파싱한 사람정보를 저장할 리스트
    private List<Person> personList;

    // 현재 파싱 중인 사람 객체
    private Person person;

    //character 메소드에서 문자열을 저장할 변수
    private String str;

    public PeopleSaxHandler() {
        personList = new ArrayList<>();
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	// 시작 태그를 만나면 person 객체를 생성하고 리스트에 추가하는 코드
        if(qName.equals("person")) {
            person = new Person();
            personList.add(person);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	// 끝 태그를 만나면 해당하는 데이터를 person 객체에 저장하는 코드
        if(qName.equals("age")) {
            person.setAge(Integer.parseInt(str));
        }else if(qName.equals("name")) {
            person.setName(str);
        }else if(qName.equals("gender")) {
            person.setGender(str);
        }else if(qName.equals("role")) {
            person.setRole(str);
        }
    } 

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //태그와 태그 사이의 내용을 처리
        str = new String(ch,start,length);
    }

    public List<Person> getPersonList(){
        return personList;
    }
    public void setPersonList(List<Person> personList) {
        this.personList=personList;
    }
}