import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import SSImportService from './ss-import.service';
import { DATE_TIME_FORMAT } from '@/shared/composables/date-format';
import { SSImport } from '@/shared/model/ss-import.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('SSImport Service', () => {
    let service: SSImportService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new SSImportService();
      currentDate = new Date();
      elemDefault = new SSImport(
        123,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        currentDate,
        false,
        'AAAAAAA',
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = {
          createTime: dayjs(currentDate).format(DATE_TIME_FORMAT),
          updateTime: dayjs(currentDate).format(DATE_TIME_FORMAT),
          ...elemDefault,
        };
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should create a SSImport', async () => {
        const returnedFromService = {
          id: 123,
          createTime: dayjs(currentDate).format(DATE_TIME_FORMAT),
          updateTime: dayjs(currentDate).format(DATE_TIME_FORMAT),
          ...elemDefault,
        };
        const expected = { createTime: currentDate, updateTime: currentDate, ...returnedFromService };

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a SSImport', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a SSImport', async () => {
        const returnedFromService = {
          uuid: 'BBBBBB',
          ssCreateBy: 'BBBBBB',
          ssFilename: 'BBBBBB',
          ssBCode: 'BBBBBB',
          ssSubBCode: 'BBBBBB',
          createBy: 'BBBBBB',
          createTime: dayjs(currentDate).format(DATE_TIME_FORMAT),
          updateBy: 'BBBBBB',
          updateTime: dayjs(currentDate).format(DATE_TIME_FORMAT),
          delFlag: true,
          remark: 'BBBBBB',
          ...elemDefault,
        };

        const expected = { createTime: currentDate, updateTime: currentDate, ...returnedFromService };
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a SSImport', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a SSImport', async () => {
        const patchObject = {
          ssCreateBy: 'BBBBBB',
          ssFilename: 'BBBBBB',
          ssBCode: 'BBBBBB',
          createTime: dayjs(currentDate).format(DATE_TIME_FORMAT),
          updateBy: 'BBBBBB',
          delFlag: true,
          ...new SSImport(),
        };
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = { createTime: currentDate, updateTime: currentDate, ...returnedFromService };
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a SSImport', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of SSImport', async () => {
        const returnedFromService = {
          uuid: 'BBBBBB',
          ssCreateBy: 'BBBBBB',
          ssFilename: 'BBBBBB',
          ssBCode: 'BBBBBB',
          ssSubBCode: 'BBBBBB',
          createBy: 'BBBBBB',
          createTime: dayjs(currentDate).format(DATE_TIME_FORMAT),
          updateBy: 'BBBBBB',
          updateTime: dayjs(currentDate).format(DATE_TIME_FORMAT),
          delFlag: true,
          remark: 'BBBBBB',
          ...elemDefault,
        };
        const expected = { createTime: currentDate, updateTime: currentDate, ...returnedFromService };
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of SSImport', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a SSImport', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a SSImport', async () => {
        axiosStub.delete.rejects(error);

        return service
          .delete(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
