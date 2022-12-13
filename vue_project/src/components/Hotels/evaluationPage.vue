<template>

  <el-rate
      v-model="value"
      show-text>
  </el-rate>
  <!--action ： 上传的地址
  file-list	上传的文件列表, 例如: [{name: 'food.jpg', url: 'https://xxx.cdn.com/xxx.jpg'}]
  disabled	是否禁用
  limit	最大允许上传个数
  -->
  <el-upload
      class="upload-demo"

      action="https://jsonplaceholder.typicode.com/posts/"
      :on-preview="handlePreview"
      :on-remove="handleRemove"
      :file-list="fileList"
      list-type="picture">
    <el-button size="small" type="primary">点击上传</el-button>
    <div class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
  </el-upload>


  <el-form-item label="视频上传" prop="storageurl">
    <!-- action必选参数, 上传的地址 -->
    <el-upload
        class="avatar-uploader el-upload--text"
        action="上传视频的后台地址"
        :show-file-list="false"
        :on-success="handleVideoSuccess"
        :before-upload="beforeUploadVideo"
        :on-progress="uploadVideoProcess"
    >
      <video
          v-if="videoForm.storageurl !== '' && videoFlag === false"
          :src="videoForm.storageurl"
          class="avatar"
          controls="controls"
      >
        您的浏览器不支持视频播放
      </video>
      <i
          v-else-if="videoForm.storageurl === '' && videoFlag === false"
          class="el-icon-plus avatar-uploader-icon"
      ></i>
      <el-progress
          v-if="videoFlag === true"
          type="circle"
          :percentage="videoUploadPercent"
          style="margin-top:30px;"
      ></el-progress>
    </el-upload>
  </el-form-item>

</template>

<script>
export default {
  name: "evaluationPage",
  data() {
    return {
      value: null,
      fileList: [{
        name: 'food.jpeg',
        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
      },
        {
          name: 'food2.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }],
      videoForm: {
        storageurl: ""// 视频地址
      }

    }
  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    beforeUploadVideo(file) {
      if (
          [
            'video/mp4',
            'video/ogg',
            'video/flv',
            'video/avi',
            'video/wmv',
            'video/rmvb'
          ].indexOf(file.type) === -1
      ) {
        this.$message.error('请上传正确的视频格式')
        return false
      }
    },
    // 上传进度显示
    uploadVideoProcess(event, file, fileList) {
      console.log(event.percent, file, fileList)
      this.videoFlag = true
      this.videoUploadPercent = Math.floor(event.percent)
    },

    // 获取上传图片地址
    handleVideoSuccess(res) {
      this.videoFlag = false
      this.videoUploadPercent = 0
      if (res.status === 200) {
        console.log(res.data)
        this.videoForm.storageurl = res.data
      } else {
        this.$message.error('视频上传失败，请重新上传！')
      }
    },
  }
}
</script>

<style scoped>
.avatar-uploader-icon {
  border: 1px dashed #d9d9d9 !important;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9 !important;
  border-radius: 6px !important;
  position: relative !important;
  overflow: hidden !important;
}

.avatar-uploader .el-upload:hover {
  border: 1px dashed #d9d9d9 !important;
  border-color: #409eff;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 300px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 300px;
  height: 178px;
  display: block;
}

</style>
