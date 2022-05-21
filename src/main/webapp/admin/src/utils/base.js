const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm63nhz/",
            name: "ssm63nhz",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm63nhz/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "微信小程序社区防疫管理系统"
        } 
    }
}
export default base
