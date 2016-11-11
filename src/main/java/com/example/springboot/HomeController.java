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
		Calendar CalendarStart = Calendar.getInstance();
		Calendar CalendarEnd = Calendar.getInstance();
		Calendar CalendarUtc = Calendar.getInstance();
		CalculateBusinessClass Calculate = new CalculateBusinessClass();
		List<String> list = new ArrayList<String>();

		//勤務時間のフォーマットをHH:mmに整える
		SimpleDateFormat workinghours = new SimpleDateFormat("HH:mm");
		String ans;
		long WorkTime,OverTime;
		CalendarStart.set(2016,0,01,00,00);
		CalendarEnd.set(2016,0,01,00,00);

		//始業時間
		CalendarStart.add(Calendar.HOUR_OF_DAY, Integer.parseInt(bean.getStartTimeHour()));
		CalendarStart.add(Calendar.MINUTE, Integer.parseInt(bean.getStartTimeMinute()));
		//終業時間
		CalendarEnd.add(Calendar.HOUR_OF_DAY, Integer.parseInt(bean.getEndTimeHour()));
		CalendarEnd.add(Calendar.MINUTE, Integer.parseInt(bean.getEndTimeMinute()));
		//勤務時間の割り出し
		WorkTime = Calculate.WORKTIME(CalendarStart, CalendarEnd, CalendarUtc.getTimeZone().getRawOffset());
		//long worktime = calendarend.getTimeInMillis() - calendarstart.getTimeInMillis() -calendarutc.getTimeZone().getRawOffset();
		//時間外労働時間の割り出し
		OverTime = Calculate.OVERTIME(bean.getEndTimeHour(), bean.getEndTimeMinute());
		/*
		if(Integer.parseInt(bean.getendtimehour()) >= 19){
			calendarover.add(Calendar.HOUR_OF_DAY, Integer.parseInt(bean.getendtimehour()) - 19);
			calendarover.add(Calendar.MINUTE, Integer.parseInt(bean.getendtimeminute()));
		}else{
			calendarover.add(Calendar.HOUR_OF_DAY, 0);
			calendarover.add(Calendar.MINUTE, 0);
		}*/

		//リストに追加
		ans = workinghours.format(WorkTime);
		list.add("勤務時間 : " + ans);
		ans = workinghours.format(OverTime);
		list.add("時間外労働時間 : " + ans);
		return list;

	}

}