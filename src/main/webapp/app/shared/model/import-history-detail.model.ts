export interface IImportHistoryDetail {
  id?: number;
  uuid?: string;
  tcihdPid?: string | null;
  tcihdLine?: string | null;
  tcihdError?: string | null;
  createBy?: string | null;
  createTime?: Date | null;
  updateBy?: string | null;
  updateTime?: Date | null;
  delFlag?: boolean | null;
  remark?: string | null;
}

export class ImportHistoryDetail implements IImportHistoryDetail {
  constructor(
    public id?: number,
    public uuid?: string,
    public tcihdPid?: string | null,
    public tcihdLine?: string | null,
    public tcihdError?: string | null,
    public createBy?: string | null,
    public createTime?: Date | null,
    public updateBy?: string | null,
    public updateTime?: Date | null,
    public delFlag?: boolean | null,
    public remark?: string | null,
  ) {
    this.delFlag = this.delFlag ?? false;
  }
}
