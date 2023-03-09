package practice;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMtest {
	public static void main(String[] args) {
		try {
			
			// 파일 생성하기
			File file = new File("D:\\A_TeachingMetereal\\3_highjava\\workspace\\javaIOTest\\src\\practice\\XMLtest.xml");

			// XML 문서 파싱하기
			//DocumentBuilderFactory => XML문서에서 DOM객체 트리를 생성하는 분석기를 얻는 팩토리 API정의
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//XML문서를 파싱하여 DOM객체를 생성
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);

			// root구하기
			Node root = document.getDocumentElement();

			// root의 속성  
//			System.out.println("클래스 이름: " + root.get("name"));
//			System.out.println();

			document.getDocumentElement().normalize();

			NodeList list = root.getChildNodes(); // 자식 노드를 가져오기 위해 getChildNodes메서드 사용

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) { // 해당 노드의 종류 판단(엘리먼트 태그가 맞는지 검사)
					Element ele = (Element) node;
					String nodeName = ele.getNodeName();

					if (nodeName.equals("person")) {
						
						System.out.println("--------------------------------------------");
						System.out.println("노드의 이름: " + ele.getAttribute("name"));
						System.out.println("--------------------------------------------");
//						System.out.println(ele.getTextContent());
						
						System.out.println("이름: " + list("name", ele));
						System.out.println("나이: " + list("age", ele));
						System.out.println("성별: " + list("gender", ele));
						System.out.println("담당: " + list("role", ele));
						System.out.println();
						
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static String list(String value, Element ele) {
		//ele요소에서 value이름을 가진 모든 하위 요소를 포함하는 NodeList를 반환
		NodeList nodes = ele.getElementsByTagName(value).item(0).getChildNodes();
		return nodes.item(0).getNodeValue();
	}
}