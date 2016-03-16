package com.github.mummyding.raidersrecord.support;

import com.github.mummyding.raidersrecord.model.RaiderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MummyDing on 16-3-16.
 * GitHub: https://github.com/MummyDing
 * Blog: http://blog.csdn.net/mummyding
 */
public class DataLoader {
    public static List<RaiderModel> load(){
        List<RaiderModel> list = new ArrayList<>();

        RaiderModel model = new RaiderModel();

        model.setActivityTitle("10元话费");
        model.setCurrentDateState("积分夺宝 11月17日 第5场");
        model.setParticipantCount(8);
        list.add(model);

        model = new RaiderModel();
        model.setActivityTitle("10元话费");
        model.setCurrentDateState("积分夺宝 11月15日 第12场");
        model.setWinner("王思聪");
        model.setFinishedTime("2015年11月15日 06:00 已开奖");
        list.add(model);

        model = new RaiderModel();
        model.setActivityTitle("10元话费");
        model.setCurrentDateState("积分夺宝 11月13日 第1场");
        model.setWinner("忘记拥抱");
        model.setFinishedTime("2015年11月13日 00:30 已开奖");
        list.add(model);
        return list;
    }
}
