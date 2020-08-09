package com.example.svp2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataUtils {

    public final static String[] imageUrls = new String[]{
            "https://img-my.csdn.net/uploads/201309/01/1378037235_3453.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037235_7476.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037235_9280.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037234_3539.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037234_6318.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037194_2965.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037193_1687.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037193_1286.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037192_8379.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037178_9374.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037177_1254.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037177_6203.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037152_6352.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037151_9565.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037151_7904.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037148_7104.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037129_8825.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037128_5291.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037128_3531.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037127_1085.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037095_7515.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037094_8001.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037093_7168.jpg",
            "https://img-my.csdn.net/uploads/201309/01/1378037091_4950.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949643_6410.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949642_6939.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949630_4505.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949630_4593.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949629_7309.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949629_8247.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949615_1986.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949614_8482.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949614_3743.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949614_4199.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949599_3416.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949599_5269.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949598_7858.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949598_9982.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949578_2770.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949578_8744.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949577_5210.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949577_1998.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949482_8813.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949481_6577.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949480_4490.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949455_6792.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949455_6345.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949442_4553.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949441_8987.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949441_5454.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949454_6367.jpg",
            "https://img-my.csdn.net/uploads/201308/31/1377949442_4562.jpg"};

    /**
     * 生成图片链接
     */
    public static List<String> buildImgUrls() {
        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=909202771," +
                "1186304507&fm=26&gp=0" +
                ".jpg");
        urls.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2059454159," +
                "2074966516&fm=15&gp=0" +
                ".jpg");
        urls.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1118463784," +
                "1657389006&fm=15&gp=0" +
                ".jpg");
        urls.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2059454159," +
                "2074966516&fm=15&gp=0" +
                ".jpg");
        urls.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2817556518," +
                "2596355765&fm=26&gp=0" +
                ".jpg");
        urls.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2438353027," +
                "1981006631&fm=26&gp=0" +
                ".jpg");
        urls.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1742365878," +
                "100654203&fm=15&gp=0" +
                ".jpg");
        urls.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3408292690," +
                "2412329074&fm=26&gp=0" +
                ".jpg");
        urls.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1118463784," +
                "1657389006&fm=15&gp=0" +
                ".jpg");
        urls.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3351789299," +
                "60233100&fm=15&gp=0" +
                ".jpg");
        return urls;
    }

    /**
     * 数据来源:http://gank.io/api/data/%E7%A6%8F%E5%88%A9/30/1
     * @return
     */
    public static List<String> buildFuliImgUrls() {
        List<String> list = new ArrayList<>();
        list.add("http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqly1g2hekfwnd7j30sg0x4djy.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fwyf0wr8hhj30ie0nhq6p.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqly1fw0vdlg6xcj30j60mzdk7.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqly1fvexaq313uj30qo0wldr4.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqly1fv5n6daacqj30sg10f1dw.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqly1fuh5fsvlqcj30sg10onjk.jpg");
        list.add("https://ws1.sinaimg.cn/large/0065oQSqly1fubd0blrbuj30ia0qp0yi.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqgy1fu39hosiwoj30j60qyq96.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqgy1ftwcw4f4a5j30sg10j1g9.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqly1ftu6gl83ewj30k80tites.jpg");
        list.add("http://ww1.sinaimg.cn/large/0065oQSqgy1ftt7g8ntdyj30j60op7dq.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqgy1ftrrvwjqikj30go0rtn2i.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqly1ftf1snjrjuj30se10r1kx.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqly1ftdtot8zd3j30ju0pt137.jpg");
        list.add("http://ww1.sinaimg.cn/large/0073sXn7ly1ft82s05kpaj30j50pjq9v.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqly1ft5q7ys128j30sg10gnk5.jpg");
        list.add("https://ww1.sinaimg.cn/large/0065oQSqgy1ft4kqrmb9bj30sg10fdzq.jpg");
        list.add("http://ww1.sinaimg.cn/large/0065oQSqly1ft3fna1ef9j30s210skgd.jpg");
        return list;
    }

    public static List<String> imgUrls() {
        List<String> urls = new ArrayList<>();
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954645354&di=d427f3880069405f95003ad6f896c00b&imgtype=0&src=http%3A%2F" +
                "%2Fpic1.win4000.com%2Fmobile%2Ff%2F53b11011d6aa0.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954025434&di=2efee7dc206da0f6e069a19273d63317&imgtype=0&src=http%3A%2F" +
                "%2Fpic.feizl.com%2Fupload%2Fallimg%2F170615%2F0516412C6-0.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954025433&di=3b6a720f010ada6273d53d88674794d0&imgtype=0&src=http%3A%2F" +
                "%2Fwww.51modo.cc%2Fupload%2Fkindeditor%2Fimage%2F20160802%2F20160802171158_21431" +
                ".jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953705979&di=b6d51eeaa95b1583acc3eb4c106776e2&imgtype=0&src=http%3A%2F%2Ft9" +
                ".baidu.com%2Fit%2Fu%3D1761131378%2C1355750940%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D667%26h%3D1000");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734440&di=47f7cf4d7cfbc9aadfdac244a4a7e3a7&imgtype=0&src=http%3A%2F%2Ft9" +
                ".baidu.com%2Fit%2Fu%3D3363001160%2C1163944807%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D1280%26h%3D830");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734440&di=569b7e17f0cf269d370ef98a071408d3&imgtype=0&src=http%3A%2F%2Ft9" +
                ".baidu.com%2Fit%2Fu%3D583874135%2C70653437%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw" +
                "%3D3607%26h%3D2408");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734439&di=277d86ac0d9fef1a147d65f9fa2f64df&imgtype=0&src=http%3A%2F%2Ft9" +
                ".baidu.com%2Fit%2Fu%3D4169540006%2C4220376401%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D1000%26h%3D1500");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734438&di=963d68cc9b22431d985e2307658eadf6&imgtype=0&src=http%3A%2F%2Ft8" +
                ".baidu.com%2Fit%2Fu%3D581096476%2C2560083681%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw" +
                "%3D1242%26h%3D1800");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734437&di=ab5b50f77444c14392b231daf334faf8&imgtype=0&src=http%3A%2F%2Ft7" +
                ".baidu.com%2Fit%2Fu%3D3225540498%2C2642373837%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D1162%26h%3D1800");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953766733&di=858ec329ac83e40f9d6e67647b23874a&imgtype=0&src=http%3A%2F%2Ft7" +
                ".baidu.com%2Fit%2Fu%3D1179872664%2C290201490%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw" +
                "%3D1280%26h%3D854");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953766733&di=b427fd9e4806a7d7aa7059a9d0378f43&imgtype=0&src=http%3A%2F%2Ft9" +
                ".baidu.com%2Fit%2Fu%3D2266751744%2C4253267866%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D1280%26h%3D854");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734436&di=4f01a13aa99719b5179e69a5039d24bc&imgtype=0&src=http%3A%2F%2Ft8" +
                ".baidu.com%2Fit%2Fu%3D705696793%2C503581032%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw" +
                "%3D1000%26h%3D1474");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734435&di=76daca4be66b8b6ccb4db3daaeb2751a&imgtype=0&src=http%3A%2F%2Ft7" +
                ".baidu.com%2Fit%2Fu%3D4050467064%2C3961079979%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D1280%26h%3D1920");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734433&di=a661901d8580a5324faab83bde52742a&imgtype=0&src=http%3A%2F%2Ft9" +
                ".baidu.com%2Fit%2Fu%3D1577456063%2C1344044640%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D1280%26h%3D853");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734433&di=d0e2c98d2563567ffbfeb13cd9c456d1&imgtype=0&src=http%3A%2F%2Ft7" +
                ".baidu.com%2Fit%2Fu%3D3055850478%2C3139240921%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D1280%26h%3D1920");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734432&di=c725f0ddde3f38cfcb989795f584bb00&imgtype=0&src=http%3A%2F%2Ft9" +
                ".baidu.com%2Fit%2Fu%3D1109883311%2C2351247922%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D1280%26h%3D853");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953734431&di=2863a17845a86cb925996f55999224f6&imgtype=0&src=http%3A%2F%2Ft9" +
                ".baidu.com%2Fit%2Fu%3D1756926446%2C2267575620%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D1280%26h%3D1920");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953874605&di=d770b374e7bb14e5683ee2f35a99dc30&imgtype=0&src=http%3A%2F%2Ft7" +
                ".baidu.com%2Fit%2Fu%3D3616242789%2C1098670747%26fm%3D79%26app%3D86%26f%3DJPEG" +
                "%3Fw%3D900%26h%3D1350");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901783&di=ed4b5f09f5ad68ee3cc46633c21b0233&imgtype=0&src=http%3A%2F" +
                "%2Fimages.china.cn%2Fattachement%2Fjpg%2Fsite1000%2F20170424" +
                "%2F7427ea210a2c1a677cda59.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901782&di=6bc6cf89a7b1e69ba81ec2165953e5fa&imgtype=0&src=http%3A%2F" +
                "%2Fpic.feizl.com%2Fupload%2Fallimg%2F170614%2F1QR95224-5.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901781&di=636c91a915f65662ed3573a917f1c597&imgtype=0&src=http%3A%2F" +
                "%2Fpic.feizl.com%2Fupload%2Fallimg%2F170615%2F1TH010Z-7.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901780&di=7ee3dc020baf45d808c9217133e30346&imgtype=0&src=http%3A%2F" +
                "%2Fpic.feizl.com%2Fupload%2Fallimg%2F170614%2F0913162K0-3.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901780&di=7d2db0b4466596e9dd8cae6e9ee98b61&imgtype=0&src=http%3A%2F%2Fn" +
                ".sinaimg.cn%2Fsinacn18%2F110%2Fw750h960%2F20180504%2F36cf-fzyqqiq9722810.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901780&di=bc471b8d88a27e9beeb036291d999ee5&imgtype=0&src=http%3A%2F" +
                "%2Fimg.improve-yourmemory.com%2Fpic%2F33afa10cf2b273b4e7beb194c0a9bcc1-0.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901779&di=663330d5832aa7774cc9a4d3cbe889b2&imgtype=0&src=http%3A%2F" +
                "%2Fpic1.win4000.com%2Fwallpaper%2Fb%2F5680fcc0d31b2.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901778&di=31d318c224fc2e149f485d84109a84aa&imgtype=0&src=http%3A%2F" +
                "%2Fhimg2.huanqiu.com%2Fattachment2010%2F2012%2F0607%2F20120607092030755.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901777&di=2523adf0376e2988d421cae1ad1ac967&imgtype=0&src=http%3A%2F%2F00" +
                ".minipic.eastday" +
                ".com%2F20161214%2F20161214140415_54838ed88878cc5f2b624176ac91d620_8.jpeg");
        urls.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1930662946," +
                "3376692344&fm=26&gp=0.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901776&di=c29571260837a08db14fa964b69ac66f&imgtype=0&src=http%3A%2F%2Fn" +
                ".sinaimg.cn%2Fsinacn00%2F584%2Fw640h744%2F20180916%2F1e2b-hkahyhx5032771.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901775&di=543444ae7db693dedfa9f91c9ef5cff9&imgtype=0&src=http%3A%2F" +
                "%2Fwww.flybridal" +
                ".com%2Fhuangse" +
                "%2FaHR0cDovL24uc2luYWltZy5jbi9zaW5hY24xNS8xNjgvdzc1OGgxMDEwLzIwMTgwNTI4L2UxMjktaGNhcXVldjU1MTM5NzUuanBn.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901775&di=88b326d1a8e50603f8db569261d667a8&imgtype=0&src=http%3A%2F" +
                "%2Fww3.sinaimg.cn%2Flarge%2F0066gL7Mgw1f6bt0nwk0tj30sg0kamz3.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901774&di=7d44724bd793b2a9180c834a56eb35ea&imgtype=0&src=http%3A%2F" +
                "%2Fpic1.win4000.com%2Fpic%2F9%2F4c%2F65f71456094.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596953901773&di=b762f8f8e98fdd75e9fea029c833446e&imgtype=0&src=http%3A%2F" +
                "%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fsoftbbs%2F1109%2F07%2Fc0" +
                "%2F8900901_1315408796310_1024x1024soft.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954025435&di=ee690ee29f7022eb18fe7d50bcb1e8d2&imgtype=0&src=http%3A%2F%2Fn" +
                ".sinaimg.cn%2Fsinacn10%2F230%2Fw750h1080%2F20181119%2Ff05d-hnyuqhi0827917.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954025434&di=80dba1c1bd53550b7b540347ca5a7807&imgtype=0&src=http%3A%2F" +
                "%2Fwww.wuhuzhongao.com%2Fimages%2Fobug65dpmnsg4lttn5uhkltdn5wq%2F20130506" +
                "%2FImg374982514.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954025434&di=731fe794a542ff213fce699deefc66ef&imgtype=0&src=http%3A%2F" +
                "%2Fwww.13k.co%2Fdown368%2Fallimg%2F160422%2F1913312057-2.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954025432&di=d50fc70e3117b6184f5b53ab9831ac1b&imgtype=0&src=http%3A%2F%2Fgb" +
                ".cri.cn%2Fmmsource%2Fimages%2F2014%2F05%2F26%2F29%2F12167560484304981273.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954025431&di=34dd18acf258fc27383a35584bb43f09&imgtype=0&src=http%3A%2F" +
                "%2Fwww.jmyx.com.cn%2Fbbs%2Fdata%2Fattachment%2Fforum%2F201310%2F27" +
                "%2F125523h5x85ek4fcerk748.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954119619&di=5eaa586efc87cfbe9244beddebc29ff3&imgtype=0&src=http%3A%2F%2Fb" +
                "-ssl.duitang.com%2Fuploads%2Fitem%2F201309%2F03%2F20130903141830_Q4Wuc.jpeg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954119619&di=5b9227acd5a0b57f598af2f2854c7d33&imgtype=0&src=http%3A%2F" +
                "%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fitbbs%2F1701%2F16%2Fc26" +
                "%2F35599129_1484564501523_mthumb.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954119618&di=a563101b84108a39a62f085c24b980ed&imgtype=0&src=http%3A%2F%2Fn" +
                ".sinaimg.cn%2Fsinacn11%2F230%2Fw750h1080%2F20180404%2F7602-fysuuya4069978.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954119617&di=ed6d903c1ee55ab32593fed71caca704&imgtype=0&src=http%3A%2F" +
                "%2Fpic1.win4000.com%2Fwallpaper%2F0%2F59929c0367397.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954119615&di=626c99944c676cab90c0f8319ad1beac&imgtype=0&src=http%3A%2F" +
                "%2Fpic1.win4000.com%2Fmobile%2F6%2F5594d4157c532.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1596954119614&di=c1d8a2e7a6d4e2004a8b1c594499c70d&imgtype=0&src=http%3A%2F" +
                "%2Fimages1.6zcool.com%2Fpic%2F1f8ffa6dc48bbd8cb08e93811d90b870-4.jpg");


        Random random = new Random();
        List<String> list = buildFuliImgUrls();
        List<String> list1 = buildImgUrls();
        int mSize = Math.min(list.size(), list1.size());
        // 随机取数据
        for (int i = 0; i < 10; i++) {
            int npos = random.nextInt(mSize - 1);
            urls.add(list.get(npos));
            urls.add(list1.get(npos));
        }
        return urls;
    }
}
