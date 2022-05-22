<template>
<div class="main-content">

    <el-tabs type="border-card">
        <el-tab-pane label="商品分类">
            <goodsType/>
        </el-tab-pane>
        <el-tab-pane label="商品列表">
            <goodsList/>
        </el-tab-pane>
    </el-tabs>
</div>
</template>
<script>
import goodsType from './goods-type.vue'
import goodsList from './goods-llist.vue'
export default {
    components: {
        goodsType,
        goodsList
    },
    data() {
        return {
            
        }
    },
}
</script>