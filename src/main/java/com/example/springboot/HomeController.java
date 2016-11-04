package com.example.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration		//Spring Bootに複雑な設定を自動設定させる
public class HomeController {

	@RequestMapping(value="/service",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces="application/json;charset=UTF-8")	//メソッドに紐付いたURLの宣言,JSONデータを選別	2016/11/4
	@ResponseBody				//JSONを返却する宣言
	public List<String> top(@RequestBody HomeModel02 bean) {				//beanインスタンスにJSONデータがマッピングされる
		List<String> list = new ArrayList<String>();
		//POSTするデータの作成
		list.add("太宰");
		list.add("夏目");
		//リクエストされたJSON形式のデータを配列に挿入	2016/11/4
		list.add(bean.getName());
		list.add(bean.getFirst());

		return list;

	}

}