<template>
    <div class="container mx-auto">
        <div class="row">
            <div class="col-md-6 mx-auto text-left">
                <div class="form-group row">
                    <label for="title"> 제목 </label>
                    <input
                        type="text"
                        class="form-control"
                        id="title"
                        name="title"
                        placeholder="제목을 입력하세요"
                        v-model="title"
                    />
                </div>
                <div class="form-group row">
                    <label for="contents"> 내용</label>
                    <textarea
                        name="contents"
                        class="form-control"
                        id="contents"
                        v-model="contents"
                        cols="30"
                        rows="10"
                    ></textarea>
                </div>

                <div class="row">
                    <button
                        type="button"
                        class="btn btn btn-sm ml-auto"
                        v-on:click="moveList"
                        id="btnList"
                    >
                        취소
                    </button>
                    <button
                        type="button"
                        class="btn btn btn-sm"
                        v-on:click="update"
                        id="btnModi"
                    >
                        수정
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            seq: 0,
            title: "",
            createdDate: "",
            hitCnt: 0,
            updatedId: "",
            creatorId: "",
            contents: "",
        };
    },
    methods: {
        moveList() {
            this.$router.push({ name: "List" });
        },
        update() {
            let obj = this;
            // axios를 사용하여 데이터 수정
            this.$axios
                .put("http://localhost:9000/updateBlogBoard", {
                    seq: this.seq,
                    title: this.title,
                    contents: this.contents,
                    updatedId: this.creatorId,
                })
                .then(function () {
                    console.log("비동기 통신 성공");
                    obj.$router.push({
                        name: "Detail",
                        query: { seq: obj.seq },
                    });
                })
                .catch(function (err) {
                    console.log("비동기 통신 실패");
                    console.log(err);
                });
        },
        boardDelete() {
            // axios를 사용하여 데이터 삭제
            let obj = this;
            this.$axios
                .delete("http://localhost:9000/deleteBlogBoard", {
                    params: {
                        seq: this.seq,
                    },
                })
                .then(function () {
                    console.log("비동기 통신 성공");
                    obj.$router.push({ name: "List" });
                })
                .catch(function (err) {
                    console.log("비동기 통신 실패");
                    console.log(err);
                });
        },
    },
    mounted() {
        let obj = this;

        obj.seq = obj.$route.params.seq;

        obj.$axios
            .get("http://localhost:9000/blogDetail", {
                params: {
                    seq: obj.$route.params.seq,
                },
            })
            .then(function (res) {
                console.log("비동기 통신 성공");

                obj.seq = res.data.seq;
                obj.createdDate = res.data.createdDate;
                obj.creatorId = res.data.creatorId;
                obj.title = res.data.title;
                obj.hitCnt = res.data.hitCnt;
                obj.contents = res.data.contents;
            })
            .catch(function (err) {
                console.log("비동기 통신 실패");
                console.log(err);
            });
    },
};
</script>

<style scoped>
.container {
    width: 100%;
    margin-top: 100px;
}
.btn {
    background-color: rgb(163, 161, 165);
    color: white;
    border-radius: 50px;
    margin-bottom: 50px;
}
#btnModi {
    background-color: rgb(163, 161, 165);
    color: white;
}
#btnList {
    background-color: rgb(67, 67, 68);
    color: white;
    margin-right: 20px;
}
</style>
