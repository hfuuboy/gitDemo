package com.iflytek.json;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
	// json字符串-简单对象型
	private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

	// json字符串-数组类型
	private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

	// 复杂格式json字符串
	private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * json字符串-简单对象型到JSONObject的转换
	 */
	@Test
	public void testJsonStrToJsonObject() {
		JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);

		System.out.println(jsonObject);
		System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
				+ jsonObject.getInteger("studentAge"));
	}

	/**
	 * JSONObject到json字符串-简单对象型的转换
	 */
	@Test
	public void testJSONObjectToJSONStr() {

		// 已知JSONObject,目标要转换为json字符串
		JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
		// 第一种方式
		String jsonString = JSONObject.toJSONString(jsonObject);

		// 第二种方式
		// String jsonString = jsonObject.toJSONString();
		System.out.println(jsonString);
	}

	/**
	 * json字符串-数组类型到JSONArray的转换
	 */
	@Test
	public void testJSONStrToJSONArray() {
		JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
		// 遍历方式1
		int size = jsonArray.size();
		for (int i = 0; i < size; i++) {

			JSONObject jsonObject = jsonArray.getJSONObject(i);
			System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
					+ jsonObject.getInteger("studentAge"));
		}
		// 遍历方式2
		for (Object obj : jsonArray) {

			JSONObject jsonObject = (JSONObject) obj;
			System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
					+ jsonObject.getInteger("studentAge"));
		}
	}

	/**
	 * JSONArray到json字符串-数组类型的转换
	 */
	@Test
	public void testJSONArrayToJSONStr() {
		// 已知JSONArray,目标要转换为json字符串
		JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
		// 第一种方式
		String jsonString = JSONArray.toJSONString(jsonArray);

		// 第二种方式
		// String jsonString = jsonArray.toJSONString(jsonArray);
		System.out.println(jsonString);
		
		String name = JSONObject.parseObject(JSON.toJSONString(jsonArray.get(0))).getString("studentName");
		System.out.println(name);
	}
	
	/**
	 * 复杂json格式字符串到JSONObject的转换
	 */
	@Test
	public void testComplexJSONStrToJSONObject() {

	    JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

	    String teacherName = jsonObject.getString("teacherName");
	    Integer teacherAge = jsonObject.getInteger("teacherAge");

	    System.out.println("teacherName:  " + teacherName + "   teacherAge:  " + teacherAge);

	    JSONObject jsonObjectcourse = jsonObject.getJSONObject("course");
	     //获取JSONObject中的数据
	    String courseName = jsonObjectcourse.getString("courseName");
	    Integer code = jsonObjectcourse.getInteger("code");

	    System.out.println("courseName:  " + courseName + "   code:  " + code);

	    JSONArray jsonArraystudents = jsonObject.getJSONArray("students");

	    //遍历JSONArray
	    for (Object object : jsonArraystudents) {

	        JSONObject jsonObjectone = (JSONObject) object;
	        String studentName = jsonObjectone.getString("studentName");
	        Integer studentAge = jsonObjectone.getInteger("studentAge");

	        System.out.println("studentName:  " + studentName + "   studentAge:  " + studentAge);
	    }
	}

	/**
	 * 复杂JSONObject到json格式字符串的转换
	 */
	@Test
	public void testJSONObjectToComplexJSONStr() {

	   //复杂JSONObject,目标要转换为json字符串
	    JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

	    //第一种方式
	    //String jsonString = JSONObject.toJSONString(jsonObject);

	    //第二种方式
	    String jsonString = jsonObject.toJSONString();
	    System.out.println(jsonString);

	}
}
