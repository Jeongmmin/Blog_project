<template>
    <div class="container">
        <!-- 왼쪽정렬 , 6칸 생성 -->
        <div class="col mx-auto text-left">
            <div class="form-group">
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
            <div class="form-group">
                <label for="creatorId"> 사용자ID </label>
                <input
                    type="text"
                    class="form-control"
                    id="creatorId"
                    name="creatorId"
                    placeholder="ID를 입력하세요"
                    v-model="creatorId"
                />
            </div>
            <div class="form-group">
                <label for="contents"> 글 내용 </label>
                <textarea
                    name="contents"
                    class="form-control"
                    id="contents"
                    v-model="contents"
                    cols="30"
                    rows="10"
                    placeholder="내용을 입력하세요"
                ></textarea>
            </div>
            <form>
            <div class="form-group">
                <!-- <label for="exampleFormControlFile1">Example file input</label> -->
                <input type="file" class="form-control-file" id="exampleFormControlFile1">
            </div>
            </form>
            <div class="row">
                <button
                    type="button"
                    class="btn btn-sm ml-auto"
                    @click="boardInsert"
                    id="btnwrite"
                >
                    등록
                </button>
                <button
                    type="button"
                    class="btn btn-sm"
                    @click="moveList"
                    id="btnlist"
                >
                    취소
                </button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            title: "",
            creatorId: "",
            contents: "",
        };
    },
    methods: {
        //axios를 사용하여 서버와 통신
        boardInsert() {
            let obj = this;
            obj.$axios
                .post("http://localhost:9000/blogBoardInsert", {
                    title: this.title,
                    contents: this.contents,
                    creatorId: this.creatorId,
                })
                .then(function () {
                    console.log("비동기 통신 성공");
                    obj.$router.push({ name: "Main" });
                })
                .catch(function (err) {
                    console.log("비동기 통신 실패");
                    console.log(err);
                });
        },
        //리스트 화면으로 이동
        moveList() {
            this.$router.push({ name: "Main" });
        },
    },
};
</script>

<style scoped>
.container {
    width: 70%;
    margin-top: 50px;
    margin-bottom: 50px;
}
.btn {
    background-color: rgb(163, 161, 165);
    color: white;
    border-radius: 50px;
    margin-bottom: 50px;
}
#btnwrite {
    background-color: rgb(163, 161, 165);
    color: white;
    margin-right: 20px;
}
#btnList {
    background-color: rgb(67, 67, 68);
    color: white;
    margin-right: 20px;
}
</style>
