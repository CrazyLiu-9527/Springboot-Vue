<template>
	
	<!-- 框架主体 -->
	<div id="app">
		<!--站点header-->
		<div class="top">
			<SiteHeader/>
		</div>
		<!--左侧菜单-->
		<div class="left">
			<SiteMenu/>
		</div>
		<!--主体页面-->
		<div class="right">
			<router-view/>
		</div>
		<!--底部-->
		<div class="bottom"></div>
	</div>
</template>

<script>
    import SiteHeader from "./components/SiteHeader";
    import SiteMenu from "./components/SiteMenu";

    export default {
        name: 'App',
        components: {
            SiteHeader,
            SiteMenu
        }
    }
</script>

<style>
	@import 'style/index.css';
	
	#app {
		font-family: Avenir, Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		color: #2c3e50;
		height: 100%;
		overflow: hidden;
		display: flex;
		flex-direction: column;
	}
	
	.top {
		position: absolute;
		top: 0;
		left: 0;
		right: 0;
		height: 54px;
	}
	
	.left {
		position: absolute;
		top: 54px;
		left: 0;
		bottom: 0;
		width: 220px;
	}
	
	.right {
		position: absolute;
		left: 220px;
		right: 0;
		top: 54px;
		bottom: 0;
		margin-top: 10px;
		margin-left: 20px;
	}
	
	.bottom {
		position: absolute;
		left: 0;
		right: 0;
		bottom: 0;
		height: 0;
	}

</style>
