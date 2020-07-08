<template>
	<div>
		
		<h1>{{title}}</h1>
		
<!--		<Button @click="show">Click me!</Button>-->
<!--		<Modal v-model="visible" title="Welcome">Welcome to ViewUI</Modal>-->
		<br>
		<Button @click="test">调用test</Button>
		<p>test数据：{{testInfo}}</p>
		<br>
		<Button @click="getUserInfo">获取登陆信息</Button>
		<p>信息：{{loginInfo}}</p>
		<br>
		<Button @click="logout">点击退出</Button>
	</div>
</template>

<script>
    import http from '../http/http'
    import apiList from "../http/api";

    export default {
        name: "TestView",
        data () {
            return {
                title: 'TestView',
                testInfo: '',
                visible: false,
                loginInfo: null,
            }
        },
        methods: {
            show () {
                this.visible = true;
            },
            test () {
                http.post(apiList.TEST, {},
                    res => {
                        this.testInfo = res.data.info;
                    },
                    error => {
                        console.log(error);
                    });
            },
            getUserInfo () {
                http.post(apiList.GET_USER_INFO, {},
                    res => {
                        this.loginInfo = res.data.map;
                    },
                    error => {
                        console.log(error);
                    });
            },
            logout () {
                window.location.href = 'http://localhost:8080' + apiList.LOGOUT;
            }
        }
    }
</script>

<style scoped>

</style>