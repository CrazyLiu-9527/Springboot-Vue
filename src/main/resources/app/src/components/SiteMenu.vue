<template>
		<Menu active-name="1-1" :open-names="['1']" width="100%">
			<Submenu name="1">
				<template slot="title">
					<Icon type="ios-analytics"/>
					菜单一
				</template>
				<menu-item name="1-1" to="/hello">Option 1</menu-item>
				<menu-item name="1-2" to="/test">Option 2</menu-item>
				<menu-item name="1-3">Option 3</menu-item>
				<menu-item name="1-4">Option 4</menu-item>
			</Submenu>
			<Submenu name="2">
				<template slot="title">
					<Icon type="ios-filing"/>
					菜单二
				</template>
				<menu-item name="2-1">Option 5</menu-item>
				<menu-item name="2-2">Option 6</menu-item>
				<Submenu name="3">
					<template slot="title">Submenu</template>
					<menu-item name="3-1">Option 7</menu-item>
					<menu-item name="3-2">Option 8</menu-item>
				</Submenu>
			</Submenu>
			<Submenu name="3">
				<template slot="title">
					<Icon type="ios-cog"/>
					菜单三
				</template>
				<MenuGroup title="Item 1">
					<menu-item name="4-1">Option 9</menu-item>
					<menu-item name="4-2">Option 10</menu-item>
				</MenuGroup>
				<MenuGroup title="Item 2">
					<menu-item name="4-3">Option 11</menu-item>
					<menu-item name="4-4">Option 12</menu-item>
				</MenuGroup>
			</Submenu>
		</Menu>
</template>

<script>

    export default {
        name: "SiteMenu",
        data () {
            return {}
        },
        mounted () {
            // 默认跳转hello页面
            this.$router.push('/hello');
        },
        methods: {}
    }
</script>

<style scoped>
	ul {
		height: 100%;
	}
	.ivu-menu-vertical.ivu-menu-light:after {
		height: 100%;
	}
</style>