<template>
	<Row class="header">
		<div class="header-wrapper"><p class="logo"><img
				src="../assets/iquality-logo.png" alt="iQuality"></p></div>
		<row class="header-userinfo">
			<div class="logout-button">
				<a type="text" @click="logout">退出</a>
			</div>
			<div class="login-userinfo">{{userInfo.displayName}}</div>
		</row>
	</Row>
</template>

<script>
    export default {
        name: "SiteHeader",
		data() {
            return{
                userInfo: {
                    displayName: 'Zhiyuan Liu （刘志远）（服务产品研发部）'
				}
			}
		},
		mounted () {
          	//todo 这里加载用户信息
        },
        methods: {
            /**
			 * 退出登陆
             */
            logout() {
            
			}
		}
    }
</script>

<style scoped>
	.header {
		align-items: center;
		-ms-flex-pack: justify;
		justify-content: space-between;
		height: 54px;
		font-size: 13px;
		color: rgba(255, 255, 255, .75);
		font-weight: 700;
		background: #001b34;
		margin-bottom: 1px;
		z-index: 999;
		position: fixed;
		top: 0;
		left: 0;
		right: 0;
		box-shadow: 0 1px 4px 0 rgba(0, 21, 41, .12);
	}
	
	.logo {
		float: left;
		display: inline-block;
		height: 25px;
		width: 121px;
		margin-left: 12px;
		margin-top: 15px;
		cursor: pointer;
	}
	.header-userinfo {
		float: right;
		display: inline-block;
		height: 25px;
		width: 380px;
		margin-left: 12px;
		margin-top: 15px;
	}
	.login-userinfo {
		float: right;
		width: 280px;
		height: 25px;
		margin-top: 5px;
	}
	.logout-button {
		float: right;
		margin-right: 20px;
		margin-top: 5px;
	}
</style>