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
		//勤務時間のフォーマットをHH:mmに整える
		SimpleDateFormat workinghours = new SimpleDateFormat("HH:mm");
		String ans;
		calendarstart.set(2016,0,01,00, 00);
		calendarend.set(2016,0,01,00, 00);
		//始業時間
		calendarstart.add(Calendar.HOUR_OF_DAY, Integer.parseInt(bean.getstarttimehour()));
		calendarstart.add(Calendar.MINUTE, Integer.parseInt(bean.getstarttimeminute()));
		//終業時間
		calendarend.add(Calendar.HOUR_OF_DAY, Integer.parseInt(bean.getendtimehour()));
		calendarend.add(Calendar.MINUTE, Integer.parseInt(bean.getendtimeminute()));
		//勤務時間の割り出し
		long worktime = calendarend.getTimeInMillis() - calendarstart.getTimeInMillis() -calendarutc.getTimeZone().getRawOffset();


		List<String> list = new ArrayList<String>();


		ans = workinghours.format(worktime);
		list.add(ans);
		return list;

	}

}