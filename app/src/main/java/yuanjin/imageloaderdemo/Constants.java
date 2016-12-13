package yuanjin.imageloaderdemo;

/**
 *  Created by WuZhanQiang on 2016/12/13.
 */

public class Constants {

    // 一堆图片链接
    public static final String[] IMAGES = new String[] {
            // Heavy images
            "http://c.hiphotos.baidu.com/zhidao/wh%3D600%2C800/sign=13d273e99922720e7b9beafc4bfb267e/b219ebc4b74543a998032c471f178a82b9011424.jpg",
            "http://d.hiphotos.baidu.com/zhidao/pic/item/d4628535e5dde7111b468ce0a3efce1b9d166114.jpg",
            "http://g.hiphotos.baidu.com/zhidao/pic/item/f2deb48f8c5494ee665ec00f29f5e0fe99257eac.jpg",
            "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1204/27/c6/11406403_1335525203384_800x800.jpg",
            "http://i7.download.fd.pchome.net/t_960x600/g1/M00/07/1A/oYYBAFNd00KIHe5pAAJHqthoEv0AABfdQHbx7MAAkfC335.jpg",
            "http://d.hiphotos.baidu.com/zhidao/pic/item/adaf2edda3cc7cd9f6effbcf3d01213fb90e91e2.jpg",
            "http://img2.imgtn.bdimg.com/it/u=2233828849,3392714258&fm=214&gp=0.jpg",
            "http://a.hiphotos.baidu.com/zhidao/pic/item/0bd162d9f2d3572cc947e03f8c13632763d0c3a8.jpg",
            "http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/08/ChMkJlbKzLqIJpetACNHYce4HUMAALI5AF5xQAAI0d5767.jpg",
            "http://imgsrc.baidu.com/forum/pic/item/d000baa1cd11728b502716a0c8fcc3cec3fd2c2d.jpg",
            "http://2t.5068.com/uploads/allimg/151027/57-15102G45304-50.jpg",
            "http://b.hiphotos.baidu.com/zhidao/pic/item/359b033b5bb5c9ea4c35ccf5d139b6003bf3b3e6.jpg",
            "http://img3.imgtn.bdimg.com/it/u=3186706237,512838661&fm=214&gp=0.jpg",
            "http://h.hiphotos.baidu.com/zhidao/pic/item/c83d70cf3bc79f3daf56b998b8a1cd11738b29e6.jpg",
            "http://e.hiphotos.baidu.com/zhidao/pic/item/aec379310a55b319c75f7e0245a98226cffc1726.jpg",
            "http://news.xinhuanet.com/games/2011-05/31/121473970_211n.jpg",
            "http://pic.58pic.com/58pic/16/41/87/61f58PICrWi_1024.jpg",
            "http://c.hiphotos.baidu.com/zhidao/pic/item/3801213fb80e7beccef9d26a2e2eb9389b506b1e.jpg",
            // Light images
            "http://img0.imgtn.bdimg.com/it/u=77388172,2913473981&fm=214&gp=0.jpg",
            "http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=063f840fd22a283443f33e0f6e85e5dc/b151f8198618367abcd2ebcf28738bd4b31ce54d.jpg",
            "http://img3.imgtn.bdimg.com/it/u=428919070,3835771174&fm=214&gp=0.jpg",
            "http://img1.3lian.com/img013/v1/36/113.jpg",
            "http://img4.duitang.com/uploads/item/201112/29/20111229164531_RNTLX.thumb.200_0.jpg",
            "http://img1.3lian.com/img013/v1/36/115.jpg",
            "http://img5.duitang.com/uploads/item/201511/27/20151127000755_ivFSP.thumb.224_0.jpeg",
            "http://img3.3lian.com/2013/v10/45/85.jpg",


            // Special cases
            "http://f.hiphotos.baidu.com/zhidao/pic/item/1e30e924b899a9011996a8bd1f950a7b0308f59e.jpg", // very large image
            "file:///sdcard/Universal Image Loader @#&=+-_.,!()~'%20.png", // Image from SD card with encoded symbols
            "assets://Living Things @#&=+-_.,!()~'%20.jpg", // Image from assets
            "drawable://" + R.mipmap.ic_launcher, // Image from drawables
            "http://upload.wikimedia.org/wikipedia/ru/b/b6/袣邪泻_泻芯褌_褋_屑褘褕邪屑懈_胁芯械胁邪谢.png", // Link with UTF-8
            "https://www.eff.org/sites/default/files/chrome150_0.jpg", // Image from HTTPS
            "http://bit.ly/soBiXr", // Redirect link
            "http://img001.us.expono.com/100001/100001-1bc30-2d736f_m.jpg", // EXIF
            "", // Empty link
            "http://wrong.site.com/corruptedLink", // Wrong link
    };

    private Constants(){

    }

    // 配置
    public static class Config{
        public static final boolean DEVELOPER_MODE = false;
    }

    // 额外类
    public static class Extra {
        public static final String IMAGES = "yuanjin.imageloaderdemo.IMAGES";
        public static final String IMAGE_POSITION = "yuanjin.imageloaderdemo.IMAGE_POSITION";
    }

}
