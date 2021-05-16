<template>
  <div class="wrapper">
    <parallax
      class="section page-header header-filter"
      :style="headerStyle"
    ></parallax>
    <div class="main main-raised">
      <div class="md-layout">
        <div
          class="md-layout-item md-size-25 md-xsmall-size-100 md-small-size-50 md-medium-size-25 "
        >
          <md-field>
            <label>Search</label>
            <md-input v-model="cropName" type="text"></md-input>
          </md-field>
        </div>
        <md-button class="md-success" @click="getPestsList(cropName)">Search</md-button>
      </div>
      <h2 class="text-center">
        {{name}}
      </h2>
      <div class="section profile-content">
        <div class="container">
          <div class="md-layout">

            <div class="md-layout-item md-size-25 md-xsmall-size-100" v-for="pest in pestslist" v-bind:key="pest">
                <div class="avatar">
                  <img
                    :src="img"
                    alt="Rounded Image"
                    class="rounded"
                  />
                </div>
                <div class="md-layout-item text-center">
                    <md-button href="#/pestsDetail/검은무늬병" class="md-simple md-success md-lg">
                    {{pest.pestName}}
                    </md-button>
                </div>
            </div>

          </div>
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
      pestslist : [],
      cropName : "",
      name : "병충해 종류를 확인할 작물을 입력해주세요",
    };
  },
  methods: {
    getPestsList(place) {
      console.log(place);
      this.name = this.cropName;
      axios({
        method: "get",
        url: `${SERVER_URL}/pests/${place}/`
      })
        .then(res => {
          this.pestslist = [];
          console.log(res.data);
          for(var i=0; i<res.data.length;i++) {
            this.pestslist.push(res.data[i]);
            console.log(res.data[i]);
          }
          for(var i=0; i<res.data.length;i++) {
            console.log(this.pestslist[i]);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/city-profile.jpg")
    },
    img: {
      type: String,
      default: require("@/assets/img/고구마/검은무늬병.jpg")
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
.avatar {
  object-fit: fill;
}
</style>
