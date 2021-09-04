<template>
<div class ="row"> 
            <!-- 왼쪽정렬 , 6칸 생성 -->
            <div class = "col-md-6 mx-auto text-left">
                <div class = "form-group">
                    <label for = "title"> 제목 : </label>
                    <input type="text" class= "form-control" id="title" name="title" placeholder="제목을 입력하세요" v-model = "title">
                </div>
                <div class="form-group">
                    <label for = "creatorId"> 사용자ID : </label>
                    <input type="text" class= "form-control" id="creatorId" name="creatorId" placeholder="ID를 입력하세요" v-model = "creatorId">
                </div>
                <div class="form-group">
                    <label for = "contents"> 글 내용 : </label>
                    <textarea name="contents" class= "form-control" id="contents" v-model = "contents" cols="30" rows="10"></textarea>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <button type = "button" class = "btn btn-outline-warning btn-block" v-on:click = "boardInsert"> 글 등록 </button>
                    </div>
                    <div class="col-md-6">
                        <button type = "button" class = "btn btn-outline-dark btn-block" v-on:click = "moveList"> 취소 </button>
                    </div>
                </div>

            </div>
        </div> 
</template>

<script>
export default {
    data() {
        return {
            title:'',
            creatorId:'',
            contents:''

        }
    },
    methods: {
        //axios를 사용하여 서버와 통신
        boardInsert() {
            let obj = this;
            obj.$axios.post('http://localhost:9000/blogBoardInsert', {
                title: this.title,
                contents: this.contents,
                creatorId: this.creatorId
            })
            .then(function() {
                console.log("비동기 통신 성공");
                obj.$router.push({name:'Main'});
                
            })
            .catch(function(err) {
                console.log("비동기 통신 실패");
                console.log(err);
            })
        },
        //리스트 화면으로 이동
        moveList() {
            this.$router.push({ name: 'Main'});
        }
    },
}
</script>

<style>

</style>
