package com.jzdata.aimedical.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author caoqiang
 * @date 2020/2/19 0019下午 16:54
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResultInfo {

  /**
   * 当前页码
   */
  private int pageIndex;

  /**
   * 每页条数
   */
  private int pageSize;

  /**
   * 数据总条数
   */
  private long totalCount;

  /**
   * 总页数
   */
  private int totalPages;

  /**
   * 返回数据
   */
  private List dataList;

}
