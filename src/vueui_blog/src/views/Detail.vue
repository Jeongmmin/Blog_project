<template>
    <div>
        <div class="row">
            <div class="container" id="btndiv">
                <div class="row">
                    <div class="col-md-12 clear-fix">
                        <button
                            type="button"
                            class="btn btn btn-sm float-right mr-2"
                            v-on:click="boardDelete"
                            id="btndel"
                        >
                            삭제
                        </button>
                        <button
                            type="button"
                            class="btn btn btn-sm float-right"
                            v-on:click="moveUpdate(seq)"
                            id="btnmodi"
                        >
                            수정
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container" id="tablediv">
            <table class="table-borderless">
                <thead>
                    <tr id="thtr">
                        <th scope="col" colspan="2">
                            <h3>{{ title }}</h3>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td col class="text-left">
                            <h6>{{ creatorId }}</h6>
                        </td>
                        <td col class="text-right">
                            <h6>{{ createdDate }}</h6>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <img src="../assets/01.jpg" /><br />
                            {{ contents }}
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="center" id="btndiv">
            <button
                type="button"
                class="btn btn btn-sm"
                v-on:click="moveList"
                id="btnlist"
            >
                목록으로
            </button>
        </div>

        <div class="container">
            <hr />
            <br />
            <h6 style="text-align: left">댓글</h6>
            <div
                class="media border p-3 m-2"
                v-for="item in items"
                v-bind:key="item.seq"
            >
                <i class="far fa-user"></i>
                <div class="media-body" style="text-align: left">
                    <h6 v-on:click="item.seq">
                        {{ item.creatorId }} <br />
                        <small
                            ><p>{{ item.createdDate }}</p></small
                        >
                    </h6>
                    <h6>{{ item.contents }}</h6>
                </div>
                <button
                    type="button"
                    class="btn btn-white float-right"
                    v-on:click="replyDelete(item.seq)"
                >
                    삭제
                </button>
            </div>
            <div class="row">
                <div class="col-md mx-auto text-left">
                    <div class="form-group">
                        <input
                            type="text"
                            class="form-control"
                            id="creatorId"
                            name="creatorId"
                            placeholder="닉네임을 입력해주세요"
                            v-model="guest"
                            size="1"
                        />
                    </div>
                    <div class="form-group">
                        <textarea
                            name="contents"
                            id="contents"
                            cols="50"
                            rows="5"
                            class="form-control"
                            placeholder="댓글을 입력해주세요"
                            v-model="replyContents"
                        ></textarea>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 clear-fix">
                        <button
                            type="button"
                            class="btn btn-sm float-right"
                            v-on:click="replyInsert"
                            id="replyInsert"
                        >
                            등록
                        </button>
                    </div>
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
            creatorId: "",
            contents: "",
            replyContents: "",
            guest: "",
            items: [],
        };
    },
    methods: {
        moveList() {
            this.$router.push({ name: "Main" });
        },
        moveUpdate(seq) {
            this.$router.push({ name: "Update", params: { seq: seq } });
        },
        boardDelete() {
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
                    console.log("axios 비동기 통신 오류");
                    console.log(err);
                });
        },
        replyList(seq) {
            this.$router.push({ name: "Detail", params: { seq: seq } });
        },
        replyInsert() {
            // 댓글 등록
            let obj = this;
            obj.$axios
                .post("http://localhost:9000/replyInsert", {
                    blogSeq: this.seq,
                    contents: this.replyContents,
                    createdDate: this.createdDate,
                    creatorId: this.guest,
                })
                .then(function () {
                    console.log("비동기 통신 성공");
                    obj.replyContents = "";
                    obj.$router.go(obj.$router.currentRouter);
                })
                .catch(function (err) {
                    console.log("비동기 통신 실패");
                    console.log(err);
                });
        },
        replyDelete(seq) {
            // axios를 사용하여 댓글 삭제
            let obj = this;
            this.$axios
                .delete("http://localhost:9000/replyDelete", {
                    params: {
                        seq: seq,
                    },
                })
                .then(function () {
                    console.log("비동기 통신 성공");
                    obj.$router.go(obj.$router.currentRouter);
                })
                .catch(function (err) {
                    console.log("비동기 통신 실패");
                    console.log(err);
                });
        },
    },
    mounted() {
        let obj = this;

        // this.boardIdx = this.$route.params.boardIdx;
        obj.seq = obj.$route.query.seq;
        // if (obj.$route.params.boardIdx == undefined || obj.$route.params.seq == null || obj.$route.params.seq == 0) {
        //     obj.seq = 16;
        // }
        // else {
        //     obj.seq = obj.$route.params.seq;
        // }

        obj.$axios
            .get("http://localhost:9000/blogDetail", {
                params: {
                    seq: obj.seq,
                },
            })
            .then(function (res) {
                console.log("비동기통신 성공");

                obj.seq = res.data.seq;
                obj.createdDate = res.data.createdDate;
                obj.creatorId = res.data.creatorId;
                obj.title = res.data.title;
                obj.hitCnt = res.data.hitCnt;
                obj.contents = res.data.contents;
            })
            .catch(function (err) {
                console.log("비동기통신 실패");
                console.log(err);
            });

        // 댓글 리스트
        obj.$axios
            .get("http://localhost:9000/replyList", {
                params: {
                    blogSeq: obj.seq,
                },
            })
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
#tablediv {
    background-color: white;
}
#btndiv {
    margin-top: 50px;
}
.container {
    width: 80%;
}
.btn {
    background-color: none;
    color: gray;
}
#btnlist {
    border-radius: 50px;
    background-color: rgb(163, 161, 165);
    color: white;
    margin-bottom: 50px;
}
#btnmodi {
    margin-right: 10px;
}
th {
    padding: 30px;
}
td {
    border-top: none;
    padding: 10px;
}
thead {
    border-bottom: 1px solid lightgray;
}
table {
    text-align: center;
    width: 100%;
}
i {
    font-size: 40px;
    padding: 20px;
    margin-right: 20px;
    margin-top: auto;
}
#replyInsert {
    border-radius: 50px;
    background-color: rgb(213, 175, 252);
    color: white;
    margin-bottom: 50px;
}
</style>

