package com.example.springboot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
			produces="application/json;charset=UTF-8")	//メソッドに紐付いたURLの宣言,JSONデータを選別
	@ResponseBody				//JSONを返却する宣言
	public List<String> top(@RequestBody HomeModel02 bean) {				//beanインスタンスにJSONデータがマッピングされる
		Calendar calendarstart = Calendar.getInstance();
		Calendar calendarend = Calendar.getInstance();
		Calendar calendarutc = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH");
		String ans;
		calendarstart.set(2016,0,01,00, 00);
		calendarend.set(2016,0,01,00, 00);
		//始業時間
		calendarstart.add(Calendar.HOUR_OF_DAY, Integer.parseInt(bean.getstarttime()));
		//終業時間
		calendarend.add(Calendar.HOUR_OF_DAY, Integer.parseInt(bean.getendtime()));

		long worktime = calendarend.getTimeInMillis() - calendarstart.getTimeInMillis() -calendarutc.getTimeZone().getRawOffset();
		/*
		//演算処理の追加
		int x,y,z;


		x = Integer.parseInt(bean.getName());
		y = Integer.parseInt(bean.getFirst());
		z = x + y;
		ans = String.valueOf(z);
		 */

		List<String> list = new ArrayList<String>();
		//POSTするデータの作成

		//list.add(ans);

		//list.add("太宰");
		//list.add("夏目");
		//リクエストされたJSON形式のデータを配列に挿入
		//list.add(bean.getName());
		//list.add(bean.getFirst());
		//System.out.println(list);

		ans = sdf1.format(worktime);
		list.add(ans);
		return list;

	}

}