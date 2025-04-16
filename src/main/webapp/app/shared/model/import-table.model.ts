export interface IImportTable {
  id?: number;
  uuid?: string;
  partNumber?: string;
  partType?: string | null;
  value?: string | null;
  schematicPart?: string | null;
  ratingVoltage?: string | null;
  ratingElectricity?: string | null;
  characteristics?: string | null;
  tolerance?: string | null;
  manufacture?: string | null;
  bCode?: string | null;
  partsName?: string | null;
  itemRegistrationClassification?: number | null;
  spiceModel?: string | null;
  pcbFootPrint?: string | null;
  delFlag?: boolean | null;
  remark?: string | null;
  createBy?: string | null;
  createTime?: Date | null;
  updateBy?: string | null;
  updateTime?: Date | null;
}

export class ImportTable implements IImportTable {
  constructor(
    public id?: number,
    public uuid?: string,
    public partNumber?: string,
    public partType?: string | null,
    public value?: string | null,
    public schematicPart?: string | null,
    public ratingVoltage?: string | null,
    public ratingElectricity?: string | null,
    public characteristics?: string | null,
    public tolerance?: string | null,
    public manufacture?: string | null,
    public bCode?: string | null,
    public partsName?: string | null,
    public itemRegistrationClassification?: number | null,
    public spiceModel?: string | null,
    public pcbFootPrint?: string | null,
    public delFlag?: boolean | null,
    public remark?: string | null,
    public createBy?: string | null,
    public createTime?: Date | null,
    public updateBy?: string | null,
    public updateTime?: Date | null,
  ) {
    this.delFlag = this.delFlag ?? false;
  }
}
