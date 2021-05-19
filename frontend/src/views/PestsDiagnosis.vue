<template>
  <div class="wrapper">
    <parallax
      class="section page-header header-filter"
      :style="headerStyle"
    ></parallax>
    <div class="main main-raised">
      <div class="md-layout">
        <div class="md-layout-item text-center">
          <h3 class="title">
            병충해 진단하기  
          </h3>
          <div class="tim-typo">
            <v-textarea
              label="작물 이름"
              auto-grow
              outlined
              rows="1"
              row-height="15"
              v-model="cropName"
            ></v-textarea>
          </div>

          <div class="tim-typo">
            <v-file-input
              accept="image/*"
              label="작물 사진 업로드"
              filled
              prepend-icon="mdi-pencil"
              id="photo"
              enctype="multipart/form-data"
              @change="Preview_image"
              v-model="image"
            ></v-file-input>
            <img v-if="Img"
              :src="Img"
              width="170px"
              class="rounded"
            />
          </div>

          <div class="tim-typo">
            <md-button class="md-success" @click="diagnose()">진단하기</md-button>
          </div>

          <a @click="move(diagnosis.result)">{{diagnosis.result}} </a>
          <h3 @click="move(diagnosis.result)">
            {{diagnosis.result}}  
          </h3>

        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

import { Tabs } from "@/components";
export default {
  components: {
  },
  bodyClass: "profile-page",
  data() {
    return {
      diagnosis : [],
      cropName : "",
      image : "",
      Img : "",
    };
  },
  methods: {
    diagnose() {
      const fd = new FormData();
      fd.append('cropName', this.cropName);
      if (document.getElementById('photo').files[0]) {
        fd.append('photo', document.getElementById('photo').files[0]);
        for (var key of fd.values()) {

  console.log(key);

}
        axios
            .post(`${SERVER_URL}/pests/diagnose`, fd)
            .then(res => {
              console.log(res.data);
              this.Img = res.data.img;
              this.diagnosis = res.data;
              alert('정보 수정이 완료되었습니다!');
            })
            .catch((error) => {
              console.log(error);
              alert('정보 수정에 실패했습니다');
            });

      }
    },

    getPestsList(place) {
      console.log(place);
      this.name = this.cropName;
      axios({
        method: "get",
        url: `${SERVER_URL}/pests/${place}/`
      })
        .then(res => {
          this.pestslist = [];
          for(var i=0; i<res.data.length;i++) {
            this.pestslist.push(res.data[i]);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    move(pestName) {
      this.$router.push('pestsDetail/'+this.cropName+'/'+pestName);
    },
    Preview_image() {
      this.Img = URL.createObjectURL(this.image);
    },

  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/city-profile.jpg")
    },
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`
      };
    }
  },
};
</script>

<style lang="scss" scoped>
.section {
  padding: 0;
}
.rounded {
  width: 300px;
  height: 150px;
  object-fit: fill;
}
</style>
