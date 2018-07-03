pragma solidity ^0.4.19;

import "./party_mem_info.sol";
import "./party_mem_id.sol";
import "./basic_info.sol";
import "./basic_info_op.sol";
import "./dev_process_op.sol";
import "./meeting_op.sol";
import "./org_info_op.sol";
import "./mem_id_op.sol";


/// @title Register: organization and operation
/// @author ["Cryptape Technologies <contact@cryptape.com>"]
contract Register {

    address public superAdmin;
    address public basicInfoOpAddr;
    address public devProcessOpAddr;
    address public memIdOpAddr;
    address public meetingOpAddr;
    address public orgInfoOpAddr;

    mapping (address => bytes32) public orgId;
    mapping (address => address) public memIdAddr;
    mapping (address => address) public memInfoAddr;
    mapping (address => address) public memBasicInfoAddr;

    event OrgNewed(
        address indexed _id,
        address indexed _info,
        address indexed _baseInfo,
        address _committee
    );
    event RegisterCreated(
        address indexed _basicInfoOPAddr,
        address indexed _devProcessOpAddr,
        address indexed _memIdOpAddr,
        address _meetingOpAddr,
        address _orgInfoOpAddr
    );

    /// @notice Contructor
    function Register(address _superAdmin) public {
        superAdmin = _superAdmin;
        basicInfoOpAddr = new BasicInfoOp();
        devProcessOpAddr = new DevProcessOp();
        memIdOpAddr = new MemIdOp();
        meetingOpAddr = new MeetingOp();
        orgInfoOpAddr = new OrgInfoOp();
        RegisterCreated(
            basicInfoOpAddr,
            devProcessOpAddr,
            memIdOpAddr,
            meetingOpAddr,
            orgInfoOpAddr
        );
    }

    /// @notice Registe a new organization
    /// @param _committee The organization address
    /// @param  _members Members's addresses in organization
    /// @return True if add successful, otherwise false
    function newOrg(
        address _committee,
        bytes32 _org,
        address[] _members,
        bytes32[] _ids
    )
        external
        returns (bool)
    {
        require(msg.sender == superAdmin);
        address idAddr = new PartyMemId(_committee, memIdOpAddr, _members, _ids);
        address infoAddr = new PartyMemInfo(_committee, devProcessOpAddr);
        address basicInfoAddr = new BasicInfo(_committee, basicInfoOpAddr);

        memIdAddr[_committee] = idAddr;
        memInfoAddr[_committee] = infoAddr;
        memBasicInfoAddr[_committee] = basicInfoAddr;
        orgId[_committee] = _org;
        OrgNewed(idAddr, infoAddr, basicInfoAddr, _committee);
        return true;
    }

    /// TODO: The operation about organization

    /// @notice Check the address is committee
    function isCommittee(address _committee)
        public
        view
        returns (bool)
    {
        return (orgId[_committee] != bytes32(0x0)); 
    }
}
