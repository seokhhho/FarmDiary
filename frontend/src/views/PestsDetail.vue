<template>
  <div class="wrapper">
    <parallax
      class="section page-header header-filter"
      :style="headerStyle"
    ></parallax>
    <div class="main main-raised">
      <h2 class="text-center">
        검은무늬병
      </h2>
      <div class="md-layout">
      <div class="md-layout-item">
        <div class="tim-typo">
          <h3 class="title">
            발생 환경
          </h3>
          <p class="text-muted">
            병원균은 병든 부위의 조직 내에서 주로 균사상태로 겨울을 지낸 후, 다음해 봄에 자낭포자 및 분생포자를 형성하여 1차 전염원이 된다. 이 병원균은 보통 병든 괴근에서 묘로, 묘에서 본포로 전반하여 병을 일으키는데, 토양 내에 존재하는 거세미의 유충이나 풍뎅이 등의 곤충이나 동물에 의한 식흔 부위에서 발병이 잘된다. 이 병의 감염은 10～34℃에서 일어나며, 발병 최적온도는 23～27℃이다.
          </p>
        </div>
        <div class="tim-typo">
          <h3 class="title">
            증상 설명
          </h3>
          <p class="text-muted">
            묘, 줄기 및 괴근에 발생한다. 묘에서는 어린 줄기의 지상부에서 검은 반점으로 나타나고, 이 반점이 확대되어 줄기를 둘러싸게 되면 잎이 누렇게 변하게 된다. 본포에서는 묘의 이식 직후부터 발생하며, 생육기 중에 줄기의 지하부에 검은 반점으로 나타난다. 줄기에서는 주로 지하부의 끝 부분에서 발병이 되며, 지상부에서는 발생이 드물다. 괴근에서는 수확기와 저장 중에 2～3㎝의 흑색 원형 내지 부정형 병반으로 나타나며, 병반 부위를 잘라보면 괴근 내부까지 검게 변해 썩어 있다. 병든 부위는 마른 상태로 썩으며, 씹어 보면 매우 쓴 맛이 난다. 병든 괴근을 가축의 사료로 쓰게 되면 식욕 감퇴, 호흡 장애, 눈의 충혈, 설사 등의 중독증세를 일으키는 것으로 알려져 있다.
          </p>
        </div>
        <div class="tim-typo">
          <h3 class="title">
            방제 방법
          </h3>
          <p class="text-muted">
            가. 이 병에 잘 걸리지 않는 품종을 선택하여 재배한다.<br>
            나. 고구마를 3년 이상 재배하지 않은 포장에서 육묘한다.<br>
            다. 병에 걸리지 않은 괴근을 파종하여 육묘하고, 건전한 묘를 선별하여 이식한다.<br>
            라. 이식 묘는 지표면으로부터 2㎝ 이상 되는 부위에서 자르도록 한다.<br>
            마. 병든 식물체는 일찍 제거한다.<br>
            바. 수확 후 바로 온도 30～35℃, 습도 90%의 이상의 조건에서 2~3일간 큐어링(curing)처리한 다음 저장하면 병 발생을 크게 줄일 수 있다.<br>
            사. 병이 발생된 포장에서 사용한 농기구는 잘 씻은 다음 사용한다.<br>
            아. 병 발생이 심한 포장은 다른 비기주 작물과 돌려짓기를 한다.<br>
          </p>
        </div>
        <div class="tim-typo">
          <h3 class="title">
            사진 정보
          </h3>
          <img
                    :src="img"
                    alt="Rounded Image"
                    class="rounded"
                  />
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
      pestsDetail : [],
      pestName : "",
    };
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/city-profile.jpg")
    },
    img: {
      type: String,
      default: require("@/assets/img/고구마/검은무늬병.jpg")
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`
      };
    }
  },
  created() {
    this.pestName = this.$route.params.pestName;
    console.log(this.pestName+"11");
    axios({
        method: "get",
        url: `${SERVER_URL}/pests/detail/${this.pestName}/`
      })
        .then(res => {
          this.pestsDetail = [];
          console.log(res.data);
          for(var i=0; i<res.data.length;i++) {
            this.pestsDetail.push(res.data[i]);
            console.log(res.data[i]);
          }
          for(var i=0; i<res.data.length;i++) {
            console.log(this.pestsDetail[i]);
          }
        })
        .catch(error => {
          console.log(error);
        });
  },
};
</script>

<style lang="scss" scoped>
.section {
  padding: 0;
}
</style>
