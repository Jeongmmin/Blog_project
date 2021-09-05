<template>
    <div class="container">
        <div class="col-md-12 mx-auto">
            <table class="table table-sm">
                <thead class="thead">
                    <tr>
                        <th>글번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="item in items" v-bind:key="item.seq">
                        <td>{{ item.seq }}</td>
                        <td class="text-left" v-on:click="moveDetail(item.seq)">
                            {{ item.title }}
                        </td>
                        <td>{{ item.creatorId }}</td>
                        <td>{{ item.createdDate }}</td>
                        <td>{{ item.hitCnt }}</td>
                    </tr>
                </tbody>
            </table>
            <div>
                <button
                    type="button"
                    class="btn btn-outline-dark float-right my-3"
                    v-on:click="moveInsert"
                >
                    글쓰기
                </button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            items: [],
        };
    },
    methods: {
        moveDetail(seq) {
            // push() - <router-link> 태그와 동일한 기능을 하는 함수
            // 화면 이동 시 파라미터값을 전송하려면 params 객체를 사용하여 데이터를 전송
            this.$router.push({ name: "Detail", params: { seq: seq } });
        },

        moveInsert() {
            this.$router.push({ name: "Insert" });
        },
    },
    mounted() {
        let obj = this;

        obj.$axios
            .get("http://localhost:9000/blogList")
            .then(function (res) {
                console.log("axios로 비동기 통신 성공");
                obj.items = res.data;
            })
            .catch(function (err) {
                console.log("axios 비동기 통신 오류");
                console.log(err);
            });
    },
};
</script>

<style scoped>
</style>
