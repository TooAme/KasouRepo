<template>
  <div class="home-container">
    <h2>数据列表</h2>
    <table-component :columns="columns" :items="tableData" />
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import TableComponent from '@/app/core/table/table.vue';

export default defineComponent({
  name: 'HomeView',
  components: {
    TableComponent,
  },
  data() {
    return {
      columns: [
        { field: 'id', label: 'ID' },
        { field: 'name', label: '名称' },
        { field: 'age', label: '年龄' },
        { field: 'address', label: '地址' },
        { field: 'email', label: '邮箱' },
      ],
      tableData: [
        {
          id: 1,
          name: '张三',
          age: 25,
          address: '北京市朝阳区',
          email: 'zhangsan@example.com',
        },
        {
          id: 2,
          name: '李四',
          age: 30,
          address: '上海市浦东新区',
          email: 'lisi@example.com',
        },
        {
          id: 3,
          name: '王五',
          age: 28,
          address: '广州市天河区',
          email: 'wangwu@example.com',
        },
        {
          id: 4,
          name: '赵六',
          age: 35,
          address: '深圳市南山区',
          email: 'zhaoliu@example.com',
        },
      ],
    };
  },
});
</script>

<style scoped>
.home-container {
  padding: 20px;
}

h2 {
  margin-bottom: 20px;
  color: #2c3e50;
}
</style>
