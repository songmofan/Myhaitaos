package songmofan.baway.com.myhaitao.model.bean;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/6/9 15
 */

public class SinginBean {



        /**
         * code : 200
         * datas : {"username":"lyl","userid":"2","key":"1647aa3aa318ecf38e1613a5a30f99f4"}
         */

        private int code;
        private DatasBean datas;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public DatasBean getDatas() {
            return datas;
        }

        public void setDatas(DatasBean datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * username : lyl
             * userid : 2
             * key : 1647aa3aa318ecf38e1613a5a30f99f4
             */

            private String username;
            private String userid;
            private String key;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }


